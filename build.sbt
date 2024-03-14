ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalProgramming"
  )

libraryDependencies ++= Seq(
  "org.jsoup" % "jsoup" % "1.15.3",
  "org.scalameta" %% "munit" % "0.7.29" % Test,
  "com.lihaoyi" %% "os-lib" % "0.9.3"
)