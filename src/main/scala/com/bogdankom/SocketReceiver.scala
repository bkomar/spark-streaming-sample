package com.bogdankom

import com.typesafe.config.{ConfigFactory}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._

/**
  * Created by bkomar
  */
object SocketReceiver {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()

    val appConfig: AppConfig = config.as[AppConfig]("app")

    val sparkConf = new SparkConf().setAppName("SimpleStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    val lines = ssc.socketTextStream(appConfig.receiver.socket.host, appConfig.receiver.socket.port)

    lines.print()

    ssc.start()
    ssc.awaitTermination()
  }
}