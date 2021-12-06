package com.alrajhi.datahub

import org.apache.spark.sql.{SparkSession}

object App{

  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .master("local")
      .appName("demo-app")
      .getOrCreate

    import spark.implicits._

    val employees = Seq(
      (1,"Mokhtar", 28),
      (1,"Ahmed", 28),
      (1,"Mohamed", 28)
    ).toDF(Seq("id", "name", "age") :_*)

    employees.show()
  }
}
