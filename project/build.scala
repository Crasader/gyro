import sbt._
import Keys._

object ExchangeBackendBuild extends Build {
    lazy val root = Project(id = "Gyro",
                            base = file(".")) aggregate(interface, servers)

    lazy val interface = Project(id = "interface",
                           base = file("interface"))

    lazy val servers = Project(id = "servers",
                           base = file("servers")) dependsOn interface
}