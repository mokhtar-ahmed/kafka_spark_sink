package com.name.datahub.context

import com.name.datahub.utils.Parser
import scala.collection.JavaConversions.mapAsScalaMap

case class DataHubContextConfig( sparkConfig:  Map[String, String],
                                 kafkaConfig:  Map[String, String],
                                 sinkConfig:   Map[String, String])

object DataHubContextConfig {

  def apply(path:String): DataHubContextConfig = {
    val url = getClass.getResource(path)
    val config = Parser.parseYaml(url)
    val sparkConfig = config.get("spark").toMap
    val kafkaConfig = config.get("kafka").toMap
    val sinkConfig = config.get("sink").toMap
    new DataHubContextConfig(sparkConfig,kafkaConfig, sinkConfig)
  }

}