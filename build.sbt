organization := "com.bogdankom"

name := "spark-streaming-sample"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "com.iheart" % "ficus_2.11" % "1.4.0",

  "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-streaming" % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided",
  "com.datastax.spark" %% "spark-cassandra-connector" % "2.0.0"
)
