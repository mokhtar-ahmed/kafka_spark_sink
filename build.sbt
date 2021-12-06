name := "spark_kafka_sink"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.4"

lazy val root = (project in file(".")).
  settings(
    name := "scala-sbt",
    version := "1.0",
    scalaVersion := "2.11.12",
    mainClass in Compile := Some("com.name.datahub.App"),
    mainClass in assembly := Some("com.name.datahub.App")
  )


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

val meta = """META.INF(.)*""".r
assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case n if n.contains("services") => MergeStrategy.concat
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case n if n.endsWith(".conf") => MergeStrategy.concat
  case meta(_) => MergeStrategy.discard
  case x => MergeStrategy.first
}

