package com.lawsofnature.common.helper

import scala.util.Random

/**
  * Created by fangzhongwei on 2016/11/23.
  */
object TokenHelper {
  val HEX_ARRAY: Array[String] = Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")

  def generate8HexToken: String = {
    generateHexToken(8)
  }

  def generateHexToken(length: Int): String = {
    val builder: StringBuilder = new StringBuilder
    for (i <- 1 to length) {
      builder.append(HEX_ARRAY(Random.nextInt(16)))
    }
    builder.toString()
  }
}
