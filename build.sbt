name := "breeze-demo"

version := "0.1"

scalaVersion := "2.11.8"

organization := "com.nones"

libraryDependencies ++= Seq(
  "com.github.scopt" %% "scopt" % "3.5.0",

  "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
  "org.apache.spark" %% "spark-mllib" % "2.1.0" % "provided",

  "org.scalanlp" %% "breeze" % "0.13",
  "org.scalanlp" %% "breeze-natives" % "0.13",
  "org.scalanlp" %% "breeze-viz" % "0.13",

  "org.scalatest"  %% "scalatest" % "3.0.0",
  "org.scalacheck" %% "scalacheck" % "1.13.4"
)

resolvers += Resolver.sonatypeRepo("public")

parallelExecution in Test := false
