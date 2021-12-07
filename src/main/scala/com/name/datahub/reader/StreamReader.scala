package com.name.datahub.reader

import com.name.datahub.context.DataHubContext
import org.apache.spark.sql.{Dataset, Row}

trait StreamReader {

  def read(context:DataHubContext,  config: Map[String, String]): Dataset[Row]

}
