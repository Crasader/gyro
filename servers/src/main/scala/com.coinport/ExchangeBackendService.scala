package com.coinport

import com.twitter.util.Future
import com.coinport.thrift.ExchangeBackend

class ExchangeBackendService extends thrift.ExchangeBackend.FutureIface {
  def hi() = Future.value {
    println("hi")
    "hi"
  }
}