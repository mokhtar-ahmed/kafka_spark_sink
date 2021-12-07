package com.name.datahub.reader

import com.name.datahub.context.DataHubContext
import org.apache.spark.sql.{Dataset, Row}

object StreamReaderBuilder {

  def apply(context: DataHubContext, config: Map[String, String]): Dataset[Row] = {
    config.getOrElse("type", "") match {
      case "kafka" => KafkaStreamReader.read(context, config)
      case _ => null
    }
  }

}
