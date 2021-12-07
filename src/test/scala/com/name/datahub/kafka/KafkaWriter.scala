package com.name.datahub.kafka

import java.util.Properties
import org.apache.kafka.clients.producer._

class KafkaWriter[K, V](props:Properties) {

  val producer  = new KafkaProducer[K, V](props)

  def write(key:K, value:V): Unit = {
    val topic = props.getProperty("topic.name")
    val record = new ProducerRecord[K, V](topic, key, value)
    producer.send(record)
  }

  def close() = {
    producer.close()
  }

}
