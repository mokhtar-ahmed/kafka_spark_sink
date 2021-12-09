package com.name.datahub.transformer
import org.apache.spark.sql.{Dataset, Row}

object UnitTransformer extends StreamTransformer {

  def apply(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = transform(ds, config)

  override def transform(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = {
    ds.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
  }

}
