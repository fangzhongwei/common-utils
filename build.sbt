name := "common-utils"

version := "1.2"

scalaVersion := "2.12.2"

organization := "com.jxjxgo.common"

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.8.4"
libraryDependencies += "com.typesafe.akka" % "akka-http-core_2.12" % "10.0.5"
libraryDependencies += "com.typesafe.akka" % "akka-http_2.12" % "10.0.5"
libraryDependencies += "org.scala-lang" % "scala-xml" % "2.11.0-M4"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
// https://mvnrepository.com/artifact/org.slf4j/slf4j-nop
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.20"


// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "3.8.0" from "http://central.maven.org/maven2/com/squareup/okhttp3/okhttp/3.8.0/okhttp-3.8.0.jar"

