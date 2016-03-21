import AssemblyKeys._

name := "eshadoop-test"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "1.4.1" % "provided"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "1.4.1" % "provided"
libraryDependencies += "org.elasticsearch" % "elasticsearch-spark_2.11" % "2.2.0-beta1"

assemblySettings

mergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
  case "log4j.properties" => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") => MergeStrategy.filterDistinctLines
  case "reference.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}
