# hello_spark_scala
spark scala example

# To Build 
Open sbt terminal and run assembly command to build fat jar 
 -> assembly 
 
# To Run

## Local 
java -jar hello_spark.jar  

## Cluster 
spark-submit --master yarn --class com.demos.App hello_spark.jar 
