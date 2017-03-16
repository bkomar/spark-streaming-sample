# spark-streaming-sample

Scala: 2.11.8
SBT:   0.13.13
Spark: 2.1.0

To build assembly jar execute:
```sbt assembly```

To run job on spark use:
```spark-submit --class com.bogdankom.SampleReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]```

To start simple streaming service run:
```nc -lkv 7777```

To track jobs result with Spark UI use:
http://localhost:4040