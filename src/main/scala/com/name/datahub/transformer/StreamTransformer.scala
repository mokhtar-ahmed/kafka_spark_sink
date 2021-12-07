package com.name.datahub.transformer

import org.apache.spark.sql.{Dataset, Row}

trait StreamTransformer {

  def transform(ds: Dataset[Row]): Dataset[Row]

}
