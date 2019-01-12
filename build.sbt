name := """play-java-hello-world-web"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.12.6", "2.11.12")

libraryDependencies += guice
libraryDependencies += "org.json" % "json" % "20180813"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"

