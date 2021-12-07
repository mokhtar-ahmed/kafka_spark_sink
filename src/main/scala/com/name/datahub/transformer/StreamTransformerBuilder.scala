package com.name.datahub.transformer

import org.apache.spark.sql.{Dataset, Row}

object StreamTransformerBuilder {

  def apply(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = {
    config.getOrElse("type", "") match {
      case "key-value-as-is" => UnitTransformer(ds)
      case _ => null
    }
  }

}
