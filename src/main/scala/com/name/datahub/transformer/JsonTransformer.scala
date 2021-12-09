package com.name.datahub.transformer

import com.name.datahub.utils.SchemaUtils._
import org.apache.spark.sql.{Dataset, Row}
import org.apache.spark.sql.functions._
import scala.collection.JavaConversions.mapAsScalaMap

object JsonTransformer extends StreamTransformer {

  def apply(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = transform(ds, config)

  override def transform(ds: Dataset[Row], config: Map[String, String]): Dataset[Row] = {
    import ds.sparkSession.implicits._
    println(config)

    val schemaConfig = config.getOrElse("topic.schema", Map.empty[String, String]).asInstanceOf[java.util.Map[String,String]].toMap
    val schema = inferSchema(schemaConfig)

    ds.selectExpr( "CAST(value AS STRING) as value")
      .withColumn("value", from_json('value, schema))
      .select("value.*")
  }

}
