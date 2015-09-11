SPARKY - An Apache Spark Sandbox
================================

This is a sandbox for exploring Apache Spark. Also, a sandbox for learning scala.

## SimpleApp
The simple standalone example from the getting started tutorial.

Running it locally on 4 cores:

	spark-submit --class "SimpleApp" --master local[4] target/scala-2.10/simple-project_2.10-1.0.jar

## Movement Derivation
A sample sandbox app for doing geoprocessing on Twitter data with Spark

Running it:
	
	spark-submit --class "MovementDerivation" --master local[4] target/scala-2.10/movement-derivation_2.10-1.0.jar