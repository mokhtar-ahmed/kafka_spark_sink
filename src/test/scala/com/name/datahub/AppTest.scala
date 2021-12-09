package com.name.datahub

import org.apache.spark.sql.SparkSession

object AppTest {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.master("local").appName("test-app").enableHiveSupport().getOrCreate
    val user_activity = spark.table("user_activity_2")
    user_activity.show(truncate = false, numRows = 100)
    user_activity.printSchema()
    println(user_activity.count())
  }
}
