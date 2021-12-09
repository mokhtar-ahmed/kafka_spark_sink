name := "spark_kafka_sink"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.4"
val kafkaVersion = "2.4.1"

lazy val root = (project in file(".")).
  settings(
    name := "scala-sbt",
    version := "1.0",
    scalaVersion := "2.11.12",
    Compile / mainClass   := Some("com.name.datahub.App"),
    assembly / mainClass  := Some("com.name.datahub.App")
  )


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion
  ,"org.apache.spark" %% "spark-sql" % sparkVersion
  ,"org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
  ,"org.apache.spark" %% "spark-hive" % sparkVersion
  ,"org.apache.kafka" %% "kafka" % kafkaVersion
  ,"org.yaml" % "snakeyaml" % "1.29"
  //,"org.json4s" %% "json4s-native" % "4.0.3"
  //,"org.json4s" %% "json4s-ext" % "4.0.3"
)

val meta = """META.INF(.)*""".r
assembly / assemblyMergeStrategy := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case n if n.contains("services") => MergeStrategy.concat
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case n if n.endsWith(".conf") => MergeStrategy.concat
  case meta(_) => MergeStrategy.discard
  case x => MergeStrategy.first
}

