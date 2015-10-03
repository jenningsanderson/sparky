name := "JSON Explorer"
version := "0.1.1"
scalaVersion := "2.10.4"

resolvers += "Spray Repository" at "http://repo.spray.io/"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.0"
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.1"