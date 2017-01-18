package com.lawsofnature.common.helper

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.util.ByteString
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object HttpHelper {
  private[this] val logger: Logger = LoggerFactory.getLogger(getClass)
  private[this] implicit val system = ActorSystem()
  private[this] implicit val materializer = ActorMaterializer()
  private[this] val timeout = 90.seconds

  def httpPost(uri: String, content: Option[String] = None, params: Option[Map[String, String]] = None): String = {
    val paramMap: Map[String, String] = params.get
    logger.info(s"http post request[uri:$uri, content:${content.get}, param:${paramMap}]")
    val request: HttpRequest = RequestBuilding.Post(uri = uri, content = content)

    if(paramMap != null && !paramMap.isEmpty) {
      val requestEntity: MessageEntity = FormData(paramMap).toEntity
      request.withEntity(requestEntity)
    }

    val httpResponse: HttpResponse = Await.result(Http().singleRequest(request), Duration.Inf)
    val bs: Future[ByteString] = httpResponse.entity.toStrict(timeout).map(_.data)
    val s: Future[String] = bs.map(_.utf8String)
    val result: String = Await.result(s, Duration.Inf)
    logger.info(s"http post response[$result]")
    result
  }

  def httpGet(url: String): String = {
    logger.info(s"http get request[url:$url]")
    val request: HttpRequest = RequestBuilding.Get(uri = url)
    val httpResponse: HttpResponse = Await.result(Http().singleRequest(request), Duration.Inf)
    val bs: Future[ByteString] = httpResponse.entity.toStrict(timeout).map(_.data)
    val s: Future[String] = bs.map(_.utf8String)
    val result: String = Await.result(s, Duration.Inf)
    logger.info(s"http get response[$result]")
    result
  }
}
