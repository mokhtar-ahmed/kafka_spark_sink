package com.name.datahub

import com.name.datahub.context.{DataHubContext, DataHubContextConfig}
import com.name.datahub.reader._
import com.name.datahub.sink.DefaultStreamSink
import com.name.datahub.transformer.UnitTransformer

object App{

  def main(args: Array[String]): Unit = {

    /*val jobId = args(0)
    val buildId = args(1)
    val jobName = args(2)
    val env = args(3)*/


    val contextConfig = DataHubContextConfig("/kafka-sink-config.yaml")
    val context = DataHubContext(contextConfig)
    val inputStream = KafkaStreamReader(context, contextConfig.kafkaConfig)
    val transformedStream = UnitTransformer(inputStream)
    val sinkStream = DefaultStreamSink(transformedStream, contextConfig.sinkConfig)
    sinkStream.start().awaitTermination()

  }
}
