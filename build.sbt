name := "eu4-tools"

version := "0.1"

scalaVersion := "2.12.8"

/*
lazy val root = (project in file("."))
  .aggregate(common, tools)

lazy val common = (project in file("common"))
*/

lazy val tools = (project in file("tools"))
  .settings(
    libraryDependencies ++= commonDepencencies
  )

lazy val dependencies =
  new {
    val scalatestV = "3.0.5"

    val scalatest = "org.scalatest" %% "scalatest" % scalatestV
  }

lazy val commonDepencencies = Seq(
  dependencies.scalatest % "test"
)
