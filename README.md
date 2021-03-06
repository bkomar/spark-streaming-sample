# spark-streaming-sample

####Dependencies:
* Scala: 2.11.8
* SBT:   0.13.13
* Spark: 2.1.0

1. To build assembly jar execute:

```bash
sbt assembly
```

### Simple socket text streaming job:
1. To submit job to spark execute:

```bash
$ spark-submit --class com.bogdankom.SocketReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]
```

2. To start simple streaming service run: (everything typed will be streamed)

```bash
$ nc -lkv 7777
```

3. Track jobs result with Spark UI:
http://localhost:4040

### Simple file streaming job:
#####Calculates number of unique words withing input folder and prints results to console

1. Put your files into '/tmp/sparkDataStreaming' (The files must be created in the dataDirectory by atomically moving or renaming them into the directory)

2. Submit Spark job:

```bash
$ spark-submit --class com.bogdankom.FsReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]
```

### Spark Streaming with Cassandra and Spark SQL:
1. Start cassandra in docker:

```bash
$ docker run --name spark-streaming-cassandra \
      -p 9040:9042 \
      -v [put you absolute path]/src/main/resources/cassandra:/tmp/cassandra-data \
      -d cassandra:3.10
```

2. Populate Cassandra with appropriate schema:

```bash
$ docker exec -it spark-streaming-cassandra  /bin/sh -c 'cqlsh -f /tmp/cassandra-data/schema.cql'
```

3. Load test dada:

```bash
$ docker exec -it spark-streaming-cassandra  /bin/sh /tmp/cassandra-data/loadData.sh
```

4. Submit Spark Job:

```bash
$ spark-submit --class com.bogdankom.CassandraReceiver target/scala-2.11/spark-streaming-sample-assembly-1.0.jar local[4]
```



###TODO:

- [ ] Refactor build to create separate jar for each Spark job
- [ ] Dockerize Cassandra init flow
- [ ] Deal with logging