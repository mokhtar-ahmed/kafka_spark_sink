package com.name.datahub.utils
import java.net.URL
import java.util.Properties
import scala.io.Source
import org.yaml.snakeyaml.Yaml


object Parser {

  def parsePropertiesFromFile(url:URL):Properties = {
    val properties = new Properties()
    val source = Source.fromURL(url)
    properties.load(source.bufferedReader())
    properties
  }


  def parseYaml(url: URL) = {
    val source = Source.fromURL(url)
    val ios = source.bufferedReader()
    val config = new Yaml().load(ios).asInstanceOf[java.util.Map[String, java.util.Map[String, String]]]
    println(config)
    config
  }


}
