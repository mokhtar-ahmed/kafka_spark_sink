package com.name.datahub.transformer

import org.apache.spark.sql.{Dataset, Row}

object StreamTransformerBuilder {

  def apply(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = {
    config.getOrElse("type", "") match {
      case "key_value_as_is" => UnitTransformer(ds, config)
      case "value_only_as_json" => JsonTransformer(ds, config)
      case _ => null
    }
  }

}
