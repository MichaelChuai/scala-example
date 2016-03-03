name := "s1"

version := "1.0"

scalaVersion := "2.11.7"

conflictManager := sbt.ConflictManager.latestRevision

val sparkVersion = "1.6.0"
libraryDependencies ++= Seq(
  "org.scalanlp" % "breeze_2.11" % "0.11.2",
  "org.scalanlp" % "breeze-natives_2.11" % "0.11.2",
  "org.apache.spark" % "spark-core_2.11" % sparkVersion % "provided",
  "org.apache.spark" % "spark-sql_2.11" % sparkVersion % "provided",
  //"org.apache.spark" % "spark-streaming_2.11" % sparkVersion % "provided",
  "org.apache.spark" % "spark-mllib_2.11" % sparkVersion % "provided",
  //"org.apache.spark" % "spark-hive_2.11" % sparkVersion % "provided",
  "org.apache.spark" % "spark-graphx_2.11" % sparkVersion % "provided",
  "com.databricks" % "spark-csv_2.11" % "1.3.0"
)
