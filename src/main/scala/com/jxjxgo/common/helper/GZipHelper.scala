package com.jxjxgo.common.helper

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.util.zip.{GZIPInputStream, GZIPOutputStream}

/**
  * Created by fangzhongwei on 2016/12/13.
  */
object GZipHelper {
  def compress(array: Array[Byte]): Array[Byte] = {
    val byteArrayOutputStream: ByteArrayOutputStream = new ByteArrayOutputStream()
    var gzipOutputStream: GZIPOutputStream = null
    try {
      gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)
      gzipOutputStream.write(array)
      gzipOutputStream.close()
      byteArrayOutputStream.toByteArray
    } finally if (gzipOutputStream != null) gzipOutputStream.close()
  }

  def uncompress(array: Array[Byte]): Array[Byte] = {
    val byteArrayOutputStream: ByteArrayOutputStream = new ByteArrayOutputStream
    val byteArrayInputStream: ByteArrayInputStream = new ByteArrayInputStream(array)
    try {
      val gzipInputStream: GZIPInputStream = new GZIPInputStream(byteArrayInputStream)
      val buffer: Array[Byte] = new Array[Byte](2048)
      var n: Int = 0
      while ( {
        n = gzipInputStream.read(buffer)
        n
      } >= 0) byteArrayOutputStream.write(buffer, 0, n)
      byteArrayOutputStream.toByteArray
    } finally {
      if (byteArrayOutputStream != null) byteArrayOutputStream.close()
      if (byteArrayInputStream != null) byteArrayInputStream.close()
    }
  }
}
