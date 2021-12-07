package com.name.datahub.kafka

import java.time.LocalDateTime
import scala.util.Random


case class UserActivity(userId:String, pageId:String, activityType:String, transactionTime:LocalDateTime){
  override def toString: String = s"""{"userId":"${userId}", "pageId":"${pageId}","activityType":"${activityType}", "transactionTime":"${transactionTime}"}"""
}

object UserActivity{

  def generateUserActivity():UserActivity = {
    UserActivity(s"user_${Random.nextInt(100)}", s"page_${Random.nextInt(20)}",
      s"activity_${Random.nextInt(10)}",  LocalDateTime.now())
  }

}



