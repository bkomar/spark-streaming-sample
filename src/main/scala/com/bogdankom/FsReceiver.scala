package com.bogdankom

import com.typesafe.config.{ConfigFactory}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
/**
  * Created by bkomar
  */
object FsReceiver {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load()
    val appConfig: AppConfig = config.as[AppConfig]("app")

    val sparkConf = new SparkConf().setAppName("FS-Streaming")
    val ssc = new StreamingContext(sparkConf, Seconds(15))

    val lines = ssc.textFileStream(appConfig.receiver.fs.input)

    val wordCountStream = lines.flatMap(_.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)

    wordCountStream.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
