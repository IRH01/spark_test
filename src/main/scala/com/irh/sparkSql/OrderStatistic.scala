package com.irh.sparkSql

import org.apache.spark.api.java.function.PairFunction
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Iritchie.ren on 2018/8/31.
  * 120.25.73.111:3306
  * qa
  * blissmall
  */
object OrderStatistic {
  def main(args: Array[String]): Unit = {
    val orderJdbcUrl = "jdbc:mysql://120.25.73.111:3306/blissmall_order?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true"
    val baseInfojJdbcUrl = "jdbc:mysql://120.25.73.111:3306/blissmall_baseinfo?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true"
    val conf = new SparkConf()
      .setAppName("JdbcOperation")
      .setMaster("spark://192.168.1.160:7077")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val readerOrder = sqlContext.read.format("jdbc")
    readerOrder.option("url", orderJdbcUrl)
    readerOrder.option("user", "qa")
    readerOrder.option("password", "blissmall")
    readerOrder.option("driver", "com.mysql.jdbc.Driver")

    val readerBaseInfo = sqlContext.read.format("jdbc")
    readerBaseInfo.option("url", baseInfojJdbcUrl)
    readerBaseInfo.option("user", "qa")
    readerBaseInfo.option("password", "blissmall")
    readerBaseInfo.option("driver", "com.mysql.jdbc.Driver")

    readerOrder.option("dbtable", "order_detail")
    val orderDetailDF = readerOrder.load
    readerBaseInfo.option("dbtable", "delivery_station")
    val deliveryStationDF = readerBaseInfo.load

    /*
    * 3、用Spark core组织待处理的数据：这里以进行join操作（DataFrame转换成 RDD后进行）为例
    */
    val resultRDD = orderDetailDF.javaRDD.mapToPair[String, Integer](new PairFunction[Row, String, Integer] {
      override def call(row: Row): (String, Integer) = {
        return (row.getAs("order_code"), row.getAs("station_id"))
      }
    }).join(deliveryStationDF.javaRDD.mapToPair[String, Integer](new PairFunction[Row, String, Integer] {
      override def call(row: Row): (String, Integer) = {
        return (row.getAs("name"), row.getAs("station_id"))
      }
    }))

    /*
    * 4、将组织好的数据交给 DataFrame 做业务处理 - 可以利用 Spark SQL 、Core、ML等进行复杂的操作！！！
    */

    sc.stop()
  }
}
