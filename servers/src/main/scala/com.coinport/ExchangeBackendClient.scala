package com.coinport

import com.twitter.finagle._
import com.twitter.util.{ Await, Future }

object ExchangeBackendClient extends App {
  val client = ThriftMux.newIface[thrift.ExchangeBackend.FutureIface]("localhost:8080")

  client.hi() onSuccess {
    case response =>
      println("Received response: " + response)
  } onFailure {
    case y =>
      println("aaa" + y)
  }

  Thread.sleep(4000)
}