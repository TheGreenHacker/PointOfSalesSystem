#!/bin/bash

sh $KAFKA_HOME/bin/kafka-console-consumer.sh --topic $1 --from-beginning --bootstrap-server localhost:9092