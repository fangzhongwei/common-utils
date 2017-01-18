package com.lawsofnature.common.helper

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.util.ByteString

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object HttpHelper {
  private[this] implicit val system = ActorSystem()
  private[this] implicit val materializer = ActorMaterializer()
  private[this] val timeout = 90.seconds

  def httpPost(uri: String, params: Option[Map[String, String]] = None, content: Option[String] = None): String = {
    val request: HttpRequest = RequestBuilding.Post(uri = uri, content = content)
    val httpResponse: HttpResponse = Await.result(Http().singleRequest(request), Duration.Inf)
    val bs: Future[ByteString] = httpResponse.entity.toStrict(timeout).map(_.data)
    val s: Future[String] = bs.map(_.utf8String)
    Await.result(s, Duration.Inf)
  }
}
