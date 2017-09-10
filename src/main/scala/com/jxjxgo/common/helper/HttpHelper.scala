package com.jxjxgo.common.helper

import java.io.IOException

import okhttp3.{OkHttpClient, Request}

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object HttpHelper {
  val client = new OkHttpClient

  @throws[IOException]
  def get(url: String, charset: String): String = {
    val request = new Request.Builder().url(url).build
    val response = client.newCall(request).execute
    try {
      new String(response.body().bytes(), charset)
    }
    finally {
      if (response != null) response.close()
    }
  }

  @throws[IOException]
  def getWithRetry(url: String, charset: String): String = {

    var success = false
    var response = ""
    var tryTimes = 0
    var exception: Exception = null

    while (tryTimes <= 3 && !success) {
      try {
        response = get(url, charset)
        success = true
      }catch {
        case ex:Exception =>
          tryTimes += 1
          exception = ex
      }
    }

    if(success) response else throw exception
  }
}
