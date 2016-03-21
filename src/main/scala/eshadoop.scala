import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.elasticsearch.spark._

object esHadoopTest {
   def main(args: Array[String]) {
      val conf = new SparkConf();
      conf.set("spark.app.name", "ES-Hadoop-Test");
      conf.set("es.nodes", "es1.mkhome");
      val sc = new SparkContext(conf);

      val numbers = Map("one" -> 1, "two" -> 2, "three" -> 3);
      val airports = Map("arrival" -> "Otopeni", "SFO" -> "San Fran");

      sc.makeRDD(Seq(numbers,airports)).saveToEs("spark/docs");

   }
}
