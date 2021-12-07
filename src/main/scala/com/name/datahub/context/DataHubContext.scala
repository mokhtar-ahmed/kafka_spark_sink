package com.name.datahub.context

import org.apache.spark.sql.SparkSession

case class DataHubContext(spark:SparkSession)

object DataHubContext {

  def apply(dataHubContextConfig: DataHubContextConfig): DataHubContext = {

    val sparkConfig = dataHubContextConfig.sparkConfig
    val appName = sparkConfig.getOrElse("app.name", "default_app_name")

    val spark = SparkSession.builder.master("local").appName(appName)

    val sparkWithConfig = sparkConfig.map{
        case (k,v) => spark.config(k.toString, v.toString)
    }.last

    val ss = sparkWithConfig.enableHiveSupport().getOrCreate()

    new DataHubContext(ss)
  }
}
