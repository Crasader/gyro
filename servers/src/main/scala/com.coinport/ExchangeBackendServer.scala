package com.coinport

import com.twitter.finagle._
import com.twitter.util.{ Await, Future }

object ExchangeBackendServer extends App {

  val iface = new ExchangeBackendService()

  val server = ThriftMux.serveIface("192.168.0.104:8080", iface)

  //server.announce("zk!localhost:2181!/testservice!1")

  println("ExchangeBackendServer is now up")
  Await.ready(server)
}