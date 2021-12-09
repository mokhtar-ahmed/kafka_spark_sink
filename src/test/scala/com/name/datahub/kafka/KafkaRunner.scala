package com.name.datahub.kafka

import com.name.datahub.utils.Parser._
import com.name.datahub.utils.Converter._
import java.util.UUID

object KafkaRunner extends App {

    val url = getClass.getResource("/kafka-producer-config.properties")
    val props = parsePropertiesFromFile(url)
    val kafkaWriter  = new KafkaWriter[String, String](props)

    while(true){
        val activity = UserActivity.generateUserActivity()
        val key = UUID.randomUUID().toString.substring(0, 6)
       // val value = toJson(activity)
        val value = activity.toString
        kafkaWriter.write(key, value)
        Thread.sleep(10000)
        println(s"Message written to kafka successfully, ${value} .")
    }

    kafkaWriter.close()

}
