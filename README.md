SPARKY - An Apache Spark Sandbox
================================

This is a sandbox for exploring Apache Spark. Also, a sandbox for learning scala.

## SimpleApp
The simple standalone example from the getting started tutorial.

Running it locally on 4 cores:

	spark-submit --class "SimpleApp" --master local[4] target/scala-2.10/simple-project_2.10-1.1.jar

## Movement Derivation
A sample sandbox app for doing geoprocessing on Twitter data with Spark

Running it:
	
	spark-submit --class "MovementDerivation" --master local[4] target/scala-2.10/movement-derivation_2.10-1.0.jar

## JSON Explorer
A sample application to read some tweets in a custom JSON format.
	
	spark-submit --class "JSONExplorer" --master local[4] --jars dependencies/spray-json_2.11-1.3.2.jar JSONExplorer/target/scala-2.10/json-explorer_2.10-0.1.1.jar

We may be able to fix all of this by just adding the jars
	--jars dependencies/spray-json_2.11-1.3.2.jar