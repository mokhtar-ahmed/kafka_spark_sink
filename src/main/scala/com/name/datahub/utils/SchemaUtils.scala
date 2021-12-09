package com.name.datahub.utils

import org.apache.spark.sql.types._


object SchemaUtils {

  def inferSchema(schemaConfig: Map[String, String]):StructType  = {

    val schemaFields = schemaConfig.map {
      case (col, dType) => StructField(col, mapType(dType), true)
    }
    new StructType(schemaFields.toArray)
  }

  def mapType(dType:String) = dType.toLowerCase match {
    case "string" => StringType
    case "timestamp" => TimestampType
    case "date" => DateType
    case "double" => DoubleType
    case "int" => IntegerType
    case _ => NullType
  }

}
