ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "Java11"
  )

libraryDependencies ++= Seq(
  "org.scalameta" %% "munit" % "0.7.29" % Test,
  "org.apache.spark" %% "spark-core" % "3.5.0",
  "org.apache.spark" %% "spark-sql" % "3.5.0" % "provided"
)
