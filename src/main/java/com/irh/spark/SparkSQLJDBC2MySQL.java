package com.irh.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * SparkSQL 通过 JDBC 操作 MySQL数据库
 *
 * @author pengyucheng
 */
public class SparkSQLJDBC2MySQL {
    static String orderJdbcUrl = "jdbc:mysql://120.25.73.111:3306/blissmall_order?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true";
    static String baseInfoJdbcUrl = "jdbc:mysql://120.25.73.111:3306/blissmall_baseinfo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true";

    public static void main(String[] args) {
        SparkConf config = new SparkConf().setMaster("spark://192.168.1.160:7077").setAppName("SparkSQLJDBC2MySQL");
        SparkContext sc = new SparkContext(config);
        SQLContext sqlContext = new SQLContext(sc);

        /*
         * 1、连接数据库：通过format（“jdbc”）的方式说明SparkSQL操作的数据来源是通过JDBC获得，JDBC后端
         * 一般都是数据库，eg、MySQL; 传递相关DB链接信息
         */
        DataFrameReader orderReader = sqlContext.read().format("jdbc");
        orderReader.option("url", orderJdbcUrl);
        orderReader.option("driver", "com.mysql.jdbc.Driver");
        orderReader.option("dbtable", "order_detail");
        orderReader.option("user", "qa");
        orderReader.option("password", "blissmall");
        Dataset<Row> orderDetailDF = orderReader.load();

        DataFrameReader baseInfoReader = sqlContext.read().format("jdbc");
        baseInfoReader.option("url", baseInfoJdbcUrl);
        baseInfoReader.option("driver", "com.mysql.jdbc.Driver");
        baseInfoReader.option("dbtable", "delivery_station");
        baseInfoReader.option("user", "qa");
        baseInfoReader.option("password", "blissmall");
        Dataset<Row> deliveryStationDF = baseInfoReader.load();

        /*
         * 2、加载相关数据
         */

        /*
         * 3、用Spark core组织待处理的数据：这里以进行join操作（DataFrame转换成 RDD后进行）为例
         */
        JavaPairRDD<String, Tuple2<Integer, Integer>> resultRDD = orderDetailDF.javaRDD().mapToPair(new PairFunction<Row, String, Integer>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Integer> call(Row row) throws Exception {
                return new Tuple2<String, Integer>(row.getAs("order_code"), row.getAs("station_id"));
            }
        }).join(deliveryStationDF.javaRDD().mapToPair(new PairFunction<Row, String, Integer>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Tuple2<String, Integer> call(Row row) throws Exception {
                return new Tuple2<String, Integer>(row.getAs("name"), row.getAs("id"));
            }
        }));

        /*
         * 4、将组织好的数据交给 DataFrame 做业务处理 - 可以利用 Spark SQL 、Core、ML等进行复杂的操作！！！
         */
        // 获取 JavaRDD<Row>
        JavaRDD<Row> resultRowRDD = resultRDD.map(new Function<Tuple2<String, Tuple2<Integer, Integer>>, Row>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Row call(Tuple2<String, Tuple2<Integer, Integer>> tuple) throws Exception {
                return RowFactory.create(tuple._1, tuple._2._1, tuple._2._2);
            }
        });
        //构建StructType，用于最后DataFrame元数据的描述
        List<StructField> fields = new ArrayList<>();
        fields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
        fields.add(DataTypes.createStructField("order_code", DataTypes.IntegerType, true));
        fields.add(DataTypes.createStructField("station_id", DataTypes.IntegerType, true));
        StructType type = DataTypes.createStructType(fields);

        Dataset<Row> personsDF = sqlContext.createDataFrame(resultRowRDD, type);

        // 具体业务处理 - 这里只是简单的 show 一下
        System.out.println("========================业务处理开始：ML，图计算等工具处理=================");
        System.out.println("==== start showing ====");
        personsDF.show();
        System.out.println("========================业务处理结束：ML，图计算等工具处理=================");

//        /*
//         * 5、保存处理后的数据：可以存放到hive，db等数据仓库中
//         */
//        personsDF.javaRDD().foreachPartition(new VoidFunction<Iterator<Row>>() {
//            private static final long serialVersionUID = 1L;
//
//            @Override
//            public void call(Iterator<Row> iterator) throws SQLException {
//                Connection conn = null;
//                StringBuilder sql = new StringBuilder("INSERT INTO dfperson VALUES ( ");
//                while (iterator.hasNext()) {
//                    Row row = iterator.next();
//                    sql.append(String.valueOf(row.getAs("name"))).append(",").append(row.getInt(1)).append(",").append(row.getInt(2));
//                }
//                sql.append(")");
//                try {
//                    conn = DriverManager.getConnection("jdbc:mysql://112.74.21.122:3306/hive", "hive", "hive");
//                    boolean flag = conn.createStatement().execute(sql.toString());
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (null != conn) conn.close();
//                }
//            }
//        });
    }
}