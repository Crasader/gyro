package com.coinport.conversions

import com.twitter.util.{ Future => TwFuture, Promise => TwPromise, Try => TwTry }
import scala.concurrent.{ Future => ScFuture, promise => ScPromise }
import scala.util.{ Try => ScTry }
import scala.concurrent.ExecutionContext.Implicits.global
import scala.reflect.ClassTag

object FutureConversion {
  implicit def twTryToScalaTry[T](tw: TwTry[T]): ScTry[T] = {
    ScTry(tw.get)
  }

  implicit def twFutureToScala[T](twFuture: TwFuture[T]): ScFuture[T] = {
    val prom = ScPromise[T]
    twFuture.respond { t: TwTry[T] =>
      prom.complete(t)
    }
    prom.future
  }

  implicit def scTryToScalaTry[T](sc: ScTry[T]): TwTry[T] = {
    TwTry(sc.get)
  }

  def toTwitterFuture[T: ClassTag](scFuture: => ScFuture[Any]): TwFuture[T] = {
    val prom = TwPromise[T]
    val clazz = implicitly[ClassTag[T]].runtimeClass
    scFuture onSuccess {
      case t if clazz.isInstance(t) => prom.setValue(t.asInstanceOf[T])
      case any => prom.setException(
        new IllegalStateException(s"Unexpected data type [${any.getClass.getName}]from Scala Future, [${clazz}] expected."))
    }
    scFuture onFailure {
      case x => prom.setException(x)
    }
    prom
  }

}