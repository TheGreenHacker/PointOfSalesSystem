#!/bin/bash

sh $KAFKA_HOME/bin/kafka-topics.sh --create --topic $1 --bootstrap-server localhost:9092 --replication-factor $2 --partitions $3