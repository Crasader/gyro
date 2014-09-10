import scalariform.formatter.preferences._

scalariformSettings

name := "ExchangeBackendServers"

scalaVersion := "2.10.4"

version := "0.0.1-SNAPSHOT"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "twitter" at "http://maven.twttr.com"

mainClass := Some("com.coinport.ExchangeBackendServer")

libraryDependencies ++= Seq(
	"com.twitter" %% "util-collection" % "6.12.1",
	"org.specs2" %% "specs2" % "2.4.2" % "test",
  	"org.slf4j" % "slf4j-simple" % "1.7.7"
)
