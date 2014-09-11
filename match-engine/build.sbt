import scalariform.formatter.preferences._

scalariformSettings

name := "MatchEngine"

scalaVersion := "2.10.4"

val akkaVersion = "2.3.6"

version := "0.0.1-SNAPSHOT"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "twitter" at "http://maven.twttr.com"

libraryDependencies ++= Seq(
	"com.twitter" %% "util-collection" % "6.12.1",
	"org.specs2" %% "specs2" % "2.4.2" % "test",
  	"org.slf4j" % "slf4j-simple" % "1.7.7",
  	"com.typesafe.akka" %% "akka-cluster" % akkaVersion,
	"com.typesafe.akka" %% "akka-contrib" % akkaVersion,
	"com.typesafe.akka" %% "akka-persistence-experimental" % akkaVersion
)
