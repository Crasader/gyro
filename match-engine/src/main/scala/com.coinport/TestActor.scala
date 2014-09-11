package com.coinport

import akka.actor._

class TestActor extends Actor {
  def receive = {
    case s: String => sender ! sender.path.toString
    case _ => sender ! "???"
  }
}

class TestModule {
  implicit val system = ActorSystem("test")

  val testActor = system.actorOf(Props[TestActor])
  println(" Actor: " + testActor)
}