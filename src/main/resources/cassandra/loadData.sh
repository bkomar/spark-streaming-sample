#!/bin/sh

cqlsh -e "copy click_stream.user_clicks (user_id,session_id,url,clicks) from '/tmp/cassandra-data/data.csv' with delimiter=',';"