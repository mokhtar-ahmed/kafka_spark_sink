package com.name.datahub.sink

import org.apache.spark.sql.streaming.DataStreamWriter
import org.apache.spark.sql.{Dataset, Row}

trait StreamSink {

  def write(ds: Dataset[Row], config:Map[String, String]): DataStreamWriter[Row]
}
