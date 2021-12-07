package com.name.datahub.sink

import com.name.datahub.sink.batch.HiveSink
import org.apache.spark.sql.streaming.DataStreamWriter
import org.apache.spark.sql._

object StreamSinkBuilder {

  def apply(ds: Dataset[Row], config:Map[String, String]): DataStreamWriter[Row] ={
    config.getOrElse("type", "") match {
      case "hive" => HiveSink(ds, config)
      case _ => null
    }
  }

}
