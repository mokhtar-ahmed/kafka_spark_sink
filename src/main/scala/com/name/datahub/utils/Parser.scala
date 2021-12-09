package com.name.datahub.utils
import java.net.URL
import java.util.Properties
import scala.io.{BufferedSource, Source}
import org.yaml.snakeyaml.Yaml


object Parser {

  def parsePropertiesFromFile(url:URL):Properties = {
    val properties = new Properties()
    val source = Source.fromURL(url)
    properties.load(source.bufferedReader())
    properties
  }


  def parseYaml(path: String) = {
    val source = Source.fromFile(path)
    val ios = source.bufferedReader()
    val config = new Yaml().load(ios).asInstanceOf[java.util.Map[String, java.util.Map[String, String]]]
    config
  }


}
