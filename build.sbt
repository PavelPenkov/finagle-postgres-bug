name := """finagle-postgres-bug"""

version := "1.0"

scalaVersion := "2.11.7"

enablePlugins(JavaAppPackaging,DockerPlugin)

dockerUpdateLatest := true

lazy val versions = new {
  val logback = "1.1.7"
}

libraryDependencies ++= Seq(
  "io.github.finagle" %% "finagle-postgres" % "0.4.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "ch.qos.logback" % "logback-core" % "1.1.7",
  "org.slf4j" % "slf4j-api" % "1.7.21"
)
