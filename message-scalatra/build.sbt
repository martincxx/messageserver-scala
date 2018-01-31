val ScalatraVersion = "2.6.2"

organization := "com.github.martincxx"

name := "Message Scalatra"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)

enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
//add scalate support
libraryDependencies +=
  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion

//add json for scala native

libraryDependencies += "org.scalatra" %% "scalatra-json" % "2.6.2"
libraryDependencies += "org.json4s" % "json4s-native_2.12" % "3.6.0-M2"
//add json for scala jackson

libraryDependencies += "org.json4s" % "json4s-jackson_2.12" % "3.6.0-M2"