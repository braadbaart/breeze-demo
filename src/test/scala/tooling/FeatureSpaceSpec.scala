import org.apache.spark.sql._
import org.scalatest._

class FeatureSpaceSpec extends FlatSpec with Matchers with DataReader with FeatureSpace {

  val spark = SparkSession.builder().master("local[2]").appName("test-feature-space").getOrCreate()
  val (colNames, trainingData) =  readCsv(spark, getClass.getResource("/train.csv").getPath)

  import spark.implicits._

  "The FeatureSpace trait" should
    "generate a feature space for matrix computation from arrays of LabeledPoint data" in {
    val featureSpace = featureMatrixFromLabeledPoint(colNames.size, trainingData.collect())
    featureSpace.cols shouldEqual trainingData.map { _.features.size }.head
    featureSpace.rows shouldEqual trainingData.count()
  }

}
