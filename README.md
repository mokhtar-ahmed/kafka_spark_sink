# Spark Scala Example

# To Build 
Open sbt terminal and run assembly command to build fat jar 
 -> assembly 
 
# To Run

### Local 
java -jar spark-kafka-sink.jar 123 1234 dev path/to/kafka-sink-config.yaml

### Cluster 
spark-submit --master yarn --class com.demos.App hello_spark.jar 123 1234 dev path/to/kafka-sink-config.yaml 
