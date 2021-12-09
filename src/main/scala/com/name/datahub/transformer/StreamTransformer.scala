package com.name.datahub.transformer

import org.apache.spark.sql.{Dataset, Row}

trait StreamTransformer {

  def transform(ds: Dataset[Row], config: Map[String, String]): Dataset[Row]

}
