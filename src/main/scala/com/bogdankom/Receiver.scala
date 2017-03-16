package com.bogdankom

import com.typesafe.config.{ConfigFactory}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by bogdankom
  */
object SampleReceiver {

  def main(args: Array[String]): Unit = {
    val config = ConfigFactory.load()

    val sparkConf = new SparkConf().setAppName("SimpleStreaming")
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    val lines = ssc.socketTextStream(
      config.getString("streaming.host"),
      config.getInt("streaming.port"))

    lines.print()

    ssc.start()
    ssc.awaitTermination()
  }
}