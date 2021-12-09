package com.name.datahub

import com.name.datahub.context.{DataHubContext, DataHubContextConfig}
import com.name.datahub.job.SinkJob

object App{

  def main(args: Array[String]): Unit = {

    val jobId = args(0)
    val buildId = args(1)
    val env = args(2)
    val sinkConfigFile = args(3)

    val config = DataHubContextConfig(sinkConfigFile)
    val context = DataHubContext(config)

    SinkJob(context, config)

  }
}
