ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.18"

lazy val root = (project in file("."))
  .settings(
    name := "FunctionalProgramming"
  )

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"
libraryDependencies += """|com.lihaoyi""".stripMargin %% "os-lib" % "0.9.3"
libraryDependencies += "com.lihaoyi" %% "upickle" % "3.2.0"
