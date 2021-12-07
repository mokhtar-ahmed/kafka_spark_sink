package com.name.datahub.job

import com.name.datahub.context.{DataHubContext, DataHubContextConfig}
import com.name.datahub.reader.{KafkaStreamReader, StreamReaderBuilder}
import com.name.datahub.sink.StreamSinkBuilder
import com.name.datahub.transformer.{StreamTransformerBuilder, UnitTransformer}

object SinkJob {

  def apply(context:DataHubContext, config: DataHubContextConfig) = {
    val inputStream = StreamReaderBuilder(context, config.inputConfig)
    val transformedStream = StreamTransformerBuilder(inputStream, config.transformerConfig)
    val sinkStream = StreamSinkBuilder(transformedStream, config.sinkConfig)
    sinkStream.start().awaitTermination()
  }

}
