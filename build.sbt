name := "hello_spark"

version := "0.1"

scalaVersion := "2.12.10"

val sparkVersion = "3.1.1"

lazy val root = (project in file(".")).
  settings(
    name := "scala-sbt",
    version := "1.0",
    scalaVersion := "2.12.10",
    mainClass in Compile := Some("com.demos.App"),
    mainClass in assembly := Some("com.demos.App")
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

