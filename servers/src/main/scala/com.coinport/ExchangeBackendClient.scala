package com.coinport

import com.twitter.finagle._
import com.twitter.util.{ Await, Future }

object ExchangeBackendClient extends App {
  val client = ThriftMux.newIface[thrift.ExchangeBackend.FutureIface]("192.168.0.104:8080")

  client.hi() onSuccess { response =>
    println("Received response: " + response)
  }

  Thread.sleep(1000)
}