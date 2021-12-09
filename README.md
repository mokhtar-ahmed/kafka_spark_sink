# Spark Scala Example

# To Build 
Open sbt terminal and run assembly command to build fat jar 
 -> assembly 
 
# To Run

### Local 
java -jar spark_kafka_sink.jar 123 1234 dev path/to/kafka-sink-config.yaml

### Cluster 
spark-submit --master yarn --class com.name.datahub.App spark_kafka_sink.jar  123 1234 dev path/to/kafka-sink-config.yaml 
