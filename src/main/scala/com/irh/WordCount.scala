package com.irh

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SparkTest")
      //设置Master_IP
      .setMaster("spark://192.168.1.160:7077")
      //提交的jar包在你本机上的位置
      .setJars(List("D:\\dev_data\\idea\\spark_test\\input\\spark_test.jar"))
      //设置driver端的ip,这里是你本机的ip
      .setIfMissing("spark.driver.host", "192.168.1.168")
    val sc = new SparkContext(sparkConf)
    println("SparkTest...")
    sc.stop
  }
}