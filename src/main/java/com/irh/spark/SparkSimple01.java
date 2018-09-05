package com.irh.spark;

import com.irh.domain.OrderDetail;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;

import java.util.Properties;

public class SparkSimple01 {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://192.168.1.168:3306/blissmall_order?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true";
        // 创建spark会话，实质上是SQLContext和HiveContext的组合
        SparkSession sparkSession = SparkSession.builder().master("spark://192.168.1.160:7077").appName("Java Spark SQL basic example").getOrCreate();
        // 设置日志级别，默认会打印DAG,TASK执行日志，设置为WARN之后可以只关注应用相关日志
        sparkSession.sparkContext().setLogLevel("WARN");
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        // 注册自定义函数
        sparkSession.sqlContext().udf().register("genderUdf", gender -> {
            if ("M".equals(gender)) {
                return "男";
            } else if ("F".equals(gender)) {
                return "女";
            }
            return "未知";
        }, DataTypes.StringType);

        // 分区方式读取mysql表数据
        Dataset<Row> orderDetail = sparkSession.read().jdbc(jdbcUrl, "order_detail", properties);
        orderDetail.cache().createOrReplaceTempView("order_detail");
        // 注册自定义函数
        Dataset<Row> orderDetailRow = sparkSession.sql("select * from order_detail where src_id = 117");
        orderDetailRow.show(10);
    }
}