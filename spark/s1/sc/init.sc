import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
//val conf = new SparkConf().setAppName("shell").setMaster("spark://localhost:7077").setExecutorEnv("executor-memory", "2G")
val conf = new SparkConf().setAppName("shell").setMaster("local[*]").setExecutorEnv("executor-memory", "2G")
val sc = new SparkContext(conf)
val sqlContext = new SQLContext(sc)

