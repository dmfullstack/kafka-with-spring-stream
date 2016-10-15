# Kafka with spring-stream support

## Description

This project is demo project for spring-stream.
Main points which will be shown is following:

- How to produce messages to kafka topic
- How top consume messages from kafka topic - TODO
- How to delete messages from kafka topic - TODO
- How to easies go through all messages in topic - TODO

## Kafka topic in use

1. **testtock**

### Example of kafka commands for message consumer
 
 ```bash
  docker exec -it kafka_kafka_1 /opt/kafka_2.11-0.10.0.1/bin/kafka-console-consumer.sh --topic=test --zookeeper zookeeper:2181 --prop --key.separator=: --prop --print.key=true --from-beginning
 ```
 
 ### Example of kafka commands for message producer
  
  ```bash
   docker exec -it kafka_kafka_1 /opt/kafka_2.11-0.10.0.1/bin/kafka-console-producer.sh --topic=test --broker-list localhost:9092 --prop --key.separator=: --prop --parse.key=true
  ```
