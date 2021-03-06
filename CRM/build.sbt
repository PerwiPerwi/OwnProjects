name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  evolutions,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc4",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "com.restfb" % "restfb" % "1.6.16"
)
