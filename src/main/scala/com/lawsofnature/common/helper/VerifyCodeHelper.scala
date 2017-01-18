package com.lawsofnature.common.helper

import scala.util.Random

/**
  * Created by fangzhongwei on 2017/1/4.
  */
object VerifyCodeHelper {

  def generateCode(length:Int): String = {
    val builder: StringBuilder = new StringBuilder
    for (i <- 1 to length) {
      builder.append(Random.nextInt(10))
    }
    builder.toString()
  }

}
