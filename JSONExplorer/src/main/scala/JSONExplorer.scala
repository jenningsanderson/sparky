/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import spray.json._
import DefaultJsonProtocol._

case class Tweet(handle: String, time: String, text: String, context: Boolean, geo: Array[Float])
object Tweet

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val tweetFormat = jsonFormat5(Tweet.apply)
}

import MyJsonProtocol._


object JSONExplorer {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("JSONExplorer")
    val sc = new SparkContext(conf)
    // // This is where we COULD set default JAR paths, if needed
    
    val tweet_file = "/Users/jenningsanderson/Documents/sparky/spark-data/sandy_tweets.json"
    val raw_tweets = sc.textFile(tweet_file)

    val tweet_objs = raw_tweets.map(t => parseToTweet(t))

    val users = tweet_objs.groupBy(_.handle)

    users.take(3).foreach(x => {
      println(x._1)
      println(x._2.size)
    })

    // tweet_objs.take(10).foreach(t => 
    //   println(t.handle)
    // )
    
    
  }

  def parseToTweet(tweet: String)={
    val jsonAst = tweet.parseJson
    jsonAst.convertTo[Tweet] 
  }

}