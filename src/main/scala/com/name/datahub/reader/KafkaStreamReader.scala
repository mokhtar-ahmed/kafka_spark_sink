package com.name.datahub.reader
import com.name.datahub.context.DataHubContext
import org.apache.spark.sql.{Dataset, Row}

object KafkaStreamReader extends StreamReader {

  override def read(context: DataHubContext, config: Map[String, String]): Dataset[Row] = {

    val streamReader = context.spark.readStream.format("kafka")

    val streamReaderWithConfig = config.map{
      case (k, v) => streamReader.option(k.toString, v.toString)
    }.last

    streamReaderWithConfig.load()
  }
}
