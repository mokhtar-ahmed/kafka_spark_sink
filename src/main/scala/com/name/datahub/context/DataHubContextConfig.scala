package com.name.datahub.context

import com.name.datahub.utils.Parser
import scala.collection.JavaConversions.mapAsScalaMap

case class DataHubContextConfig(sparkConfig:  Map[String, String],
                                inputConfig:  Map[String, String],
                                transformerConfig:  Map[String, String],
                                sinkConfig:  Map[String, String])

object DataHubContextConfig {

  def apply(path:String): DataHubContextConfig = {
    val url = getClass.getResource(path)
    val config = Parser.parseYaml(url)
    val sparkConfig = config.get("spark").toMap
    val inputConfig = config.get("input").toMap
    val transformerConfig = config.get("transformer").toMap
    val sinkConfig = config.get("sink").toMap

    new DataHubContextConfig(sparkConfig, inputConfig, transformerConfig, sinkConfig)
  }

}