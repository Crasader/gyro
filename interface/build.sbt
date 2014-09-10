name := "ExchangeBackend"

scalaVersion := "2.10.4"

version := "0.0.1-SNAPSHOT"

val finagleVersion = "6.20.0"

com.twitter.scrooge.ScroogeSBT.newSettings

// publishTo <<= version { (v: String) =>
//   val nexus = ""
//   if (v.trim.endsWith("SNAPSHOT"))
//     Some("snapshots" at nexus + "content/repositories/snapshots")
//   else
//     Some("releases"  at nexus + "content/repositories/releases")
// }

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

resolvers += "twitter" at "http://maven.twttr.com"

libraryDependencies ++= Seq(
	"com.twitter" %% "finagle-thrift" % finagleVersion,
	"com.twitter" %% "finagle-thriftmux" % finagleVersion,
	"org.apache.thrift" % "libthrift" % "0.8.0",
	"com.twitter" %% "scrooge-runtime" % "3.16.3"
)