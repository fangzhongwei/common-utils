package com.jxjxgo.common.helper

import java.io.IOException

import okhttp3.{OkHttpClient, Request}
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object HttpHelper {
  val client = new OkHttpClient
  private[this] val logger: Logger = LoggerFactory.getLogger(getClass)

  @throws[IOException]
  def get(url: String): String = {
    val request = new Request.Builder().url(url).build
    val response = client.newCall(request).execute
    try {
      response.body.string
    }
    finally {
      if (response != null) response.close()
    }
  }
}
