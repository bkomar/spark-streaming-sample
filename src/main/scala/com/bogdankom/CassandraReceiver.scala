package com.bogdankom

import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.ConstantInputDStream
import com.datastax.spark.connector.streaming._
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
/**
  * Created by bkomar
  */
object CassandraReceiver {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load()
    val appConfig: AppConfig = config.as[AppConfig]("app")

    val sparkConf = new SparkConf()
      .setAppName("FS-Streaming")
      .set("spark.cassandra.connection.host", appConfig.receiver.cassandra.host)

    val ssc = new StreamingContext(sparkConf, Seconds(20))

    //Make sure that the data that is being queried does not grow unbounded
    val cassandraRDD = ssc.cassandraTable("click_stream", "user_clicks")
      .select("user_id", "session_id", "clicks")

    cassandraRDD.saveAsTextFile("sampleData")

    ssc.start()
    ssc.awaitTermination()
  }
}
