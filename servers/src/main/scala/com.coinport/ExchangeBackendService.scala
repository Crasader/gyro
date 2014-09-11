package com.coinport

import com.twitter.util.Future
import com.coinport.thrift.ExchangeBackend
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import conversions.FutureConversion._

class ExchangeBackendService extends thrift.ExchangeBackend.FutureIface {

  val m = new TestModule()
  implicit val timeout = Timeout(10 seconds)
  def hi(): Future[String] = toTwitterFuture[String] {
    m.testActor ? "hhhh"
  }
}