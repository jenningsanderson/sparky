/* SimpleApp.scala */
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import spray.json._
import DefaultJsonProtocol._

// case class Tweet(handle: String, time: String, text: String, context: Boolean)
// object Tweet

// object MyTweetProtocol extends DefaultJsonProtocol {
//   implicit val tweetFormat = jsonFormat4(Tweet)
// }

case class Color(name: String, red: Int, green: Int, blue: Int)

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val colorFormat = jsonFormat4(Color)
}

import MyJsonProtocol._


// import MyTweetProtocol._

object JSONExplorer {

  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("JSON Explorer")
    val sc = new SparkContext(conf)
    //This is where we COULD set default JAR paths, if needed
    
    val tweet_file = "/Users/jenningsanderson/Documents/sparky/spark-data/sandy_tweets.json"
    val raw_tweets = sc.textFile(tweet_file)

    val json = Color("CadetBlue", 95, 158, 160).toJson; null
    val color = json.convertTo[Color]

    println(color)

    // val string = raw_tweets.take(10).foreach(parseToTweet)
  }

  // def parseToTweet(tweet: String)={
  //   val jsonAst = tweet.parseJson
  //   val pretty  = jsonAst.convertTo[Tweet]
  //   //println(pretty)
  // }

}