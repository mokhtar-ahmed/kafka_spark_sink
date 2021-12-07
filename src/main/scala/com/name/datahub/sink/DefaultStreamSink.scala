package com.name.datahub.sink

import com.name.datahub.sink.batch.HiveSink
import org.apache.spark.sql.streaming.DataStreamWriter
import org.apache.spark.sql.{DataFrame, Dataset, Row, SaveMode}

object DefaultStreamSink extends StreamSink {

  def apply(ds: Dataset[Row], config:Map[String, String]) = write(ds, config)

  override def write(ds: Dataset[Row], config:Map[String, String]): DataStreamWriter[Row] = {
    config.getOrElse("type", "") match {
      case "hive" => HiveSink(ds, config)
      case _ => null
    }

  }
}
