/* osm-sandbox.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

// import com.twitter.elephantbird.mapreduce.input.MultiInputFormat
// import com.twitter.elephantbird.mapreduce.io.BinaryWritable

import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.mapreduce.Job
import org.apache.spark._

//Attempting to load an OSM file with Spark... Here we go.

object OSMSandbox {
  def main(args: Array[String]) {
    val logFile = "/usr/local/Cellar/apache-spark/1.4.1/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("OSMSandbox")
    val sc = new SparkContext(conf)

    // val conf = sparkConf.getConfiguration

    // These come from https://github.com/MammothData/spark-protobuf/blob/master/src/main/scala/com/mammothdatallc/spark/SparkReadProtoBuf.scala
    // conf.set("io.compression.codecs", "com.hadoop.compression.lzo.LzopCodec")
    // conf.set("io.compression.codec.lzo.class", "com.hadoop.compression.lzo.LzoCodec")

    MultiInputFormat.setClassConf(classOf[MyProtocolBuffers.MyProtocolBuffer], conf)

    // val data = sc
    //   .newAPIHadoopFile[LongWritable, BinaryWritable[MyProtocolBuffers.MyProtocolBuffer],
    //   MultiInputFormat[MyProtocolBuffers.MyProtocolBuffer]](
    //     "/tmp/SparkWriteProtoBuf/*.lzo", classOf[MultiInputFormat[MyProtocolBuffers.MyProtocolBuffer]],
    //     classOf[LongWritable],
    //     classOf[BinaryWritable[MyProtocolBuffers.MyProtocolBuffer]], conf)

    // val input = data.map { case (x, y) =>
    //   (x.get, y match {
    //     case b: BinaryWritable[MyProtocolBuffers.MyProtocolBuffer] => b.get()
    //     case _ => throw new Exception("Unexpected input")
    //   }
    //     )
    // }

    // println(input.collect().mkString(","))

    // sc.stop()
    

    //val logData = sc.textFile(logFile, 2).cache()
    //val numAs = logData.filter(line => line.contains("a")).count()
    //val numBs = logData.filter(line => line.contains("b")).count()
    //println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
