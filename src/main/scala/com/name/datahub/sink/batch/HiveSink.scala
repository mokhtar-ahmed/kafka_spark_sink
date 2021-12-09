package com.name.datahub.sink.batch

import org.apache.spark.sql.{DataFrame, Row, SaveMode}
import org.apache.spark.sql.streaming.DataStreamWriter

object HiveSink {

  def apply(df: DataFrame, config:Map[String, String]): DataStreamWriter[Row] = {

    val tableName = config.getOrElse("table.name", "")
    val checkpointLocation = config.getOrElse("checkpoint.location", null)

    val writeMode = config.getOrElse("write.mode", "") match {
      case "overwrite" => SaveMode.Overwrite
      case "append" => SaveMode.Append
      case _ => SaveMode.ErrorIfExists
    }

    df.writeStream
      .option("checkpointLocation", checkpointLocation)
      .foreachBatch {
        (df: DataFrame, id: Long) => {
          df.show(truncate = false)
          df.write.mode(writeMode).saveAsTable(tableName)
        }
    }

  }
}
