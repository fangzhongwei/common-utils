package com.lawsofnature.common.helper

/**
  * Created by fangzhongwei on 2016/12/12.
  */
object ByteHelper {
  /**
    * int到byte[]
    *
    * @param i
    * @return
    */
  def intToByteArray(i: Int): Array[Byte] = {
    val result: Array[Byte] = new Array[Byte](4)
    //由高位到低位
    result(0) = ((i >> 24) & 0xFF).toByte
    result(1) = ((i >> 16) & 0xFF).toByte
    result(2) = ((i >> 8) & 0xFF).toByte
    result(3) = (i & 0xFF).toByte
    result
  }

  /**
    * byte[]转int
    *
    * @param bytes
    * @return
    */
  def byteArrayToInt(bytes: Array[Byte]): Int = {
    var value: Int = 0
    //由高位到低位
    var i: Int = 0
    while (i < 4) {
      {
        val shift: Int = (4 - 1 - i) * 8
        value += (bytes(i) & 0x000000FF) << shift //往高位游
      }
      {
        i += 1; i - 1
      }
    }
    value
  }
}
