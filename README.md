# spring-boot-kafka-example
This Project covers how to use Spring Boot with Spring Kafka to Publish JSON/String message to a Kafka topic

## Prerequisites
- Java 11+
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Zookeeper](https://zookeeper.apache.org/)
- [Kafka](https://kafka.apache.org/documentation/)

## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)
- Kafka (any commandline tool)

## Install Kafka and ZooKeeper
Step 1: Download Kafka from [Kafka site](https://kafka.apache.org/downloads)

Step 2: Extract the folder to 

Step 3: Run ZooKeeper and Kafka by using the terminal

  Start with Zookeeper:

     Linux: bin/zookeeper-server-start.sh config/zookeeper.properties
     
     Window: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
     
  Start with Kafka:

     Linux: bin/kafka-server-start.sh config/server.properties
     
     Window: bin/kafka-server-start.bat config/server.properties

if the terminal has errors:

  ZooKeeper:
  
    The input line is too long: rename `kafka_x.x-x.x.x` to `kafka`
    
    The system cannot find the path specified: edit `set JAVA="%JAVA_HOME%/bin/java"` to `set JAVA="%JAVA_HOME%/java"` in \bin\windows\kafka-run-class.bat or \bin\kafka-run-class.sh file

  Kafka:

    Timed out waiting for connection while in state: CONNECTING: edit `#listeners=PLAINTEXT://:9092` to `listeners=PLAINTEXT://:9092` in \config\server file

## Consume from the Kafka Topic via Console

    window: .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning
    
    linux: bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic kafka-topic --from-beginning

## Publish message via WebService
http://localhost:8080/api/v1/kafka/publish
