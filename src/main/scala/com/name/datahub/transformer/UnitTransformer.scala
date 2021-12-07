package com.name.datahub.transformer
import org.apache.spark.sql.{Dataset, Row}

object UnitTransformer extends StreamTransformer {

  def apply(ds: Dataset[Row]): Dataset[Row] = transform(ds)

  override def transform(ds: Dataset[Row]): Dataset[Row] = {
    ds.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
  }

}
