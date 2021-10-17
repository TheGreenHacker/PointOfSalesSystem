#!/bin/bash

sh $KAFKA_HOME/bin/kafka-topics.sh --delete --topic $1 --bootstrap-server localhost:9092