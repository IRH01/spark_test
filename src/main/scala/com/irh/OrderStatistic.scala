package com.irh

import java.util.Properties

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Iritchie.ren on 2018/8/31.
  */
object OrderStatistic {
  def main(args: Array[String]): Unit = {
    val jdbcUrl = "jdbc:mysql://120.25.73.111:3306/blissmall_order?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&allowMultiQueries=true"
    val conf = new SparkConf().setAppName("JdbcOperation").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    val properties = new Properties()
    properties.put("user", "qa")
    properties.put("password", "blissmall")
    val orderDetail = sqlContext.read.jdbc(jdbcUrl, "order_detail", properties)
    orderDetail.show()
    sc.stop()
  }
}