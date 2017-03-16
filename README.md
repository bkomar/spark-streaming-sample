# spark-streaming-sample

####Dependencies:
* Scala: 2.11.8
* SBT:   0.13.13
* Spark: 2.1.0

1. To build assembly jar execute:

```sbt assembly```

### Simple socket text streaming job:
1. To submit job to spark execute:

```$ spark-submit --class com.bogdankom.SocketReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]```

2. To start simple streaming service run: (everything typed will be streamed)

```$ nc -lkv 7777```

3. To track jobs result with Spark UI use: 
http://localhost:4040

### Simple file streaming job:
#####Calculates number of unique words withing input folder and prints results to console

1. Put your files into '/tmp/sparkDataStreaming' (The files must be created in the dataDirectory by atomically moving or renaming them into the directory)

2. To submit job to spark execute

```$ spark-submit --class com.bogdankom.FsReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]``


###TODO:
[ ] Refactor build to create separate jar for each Spark job
 