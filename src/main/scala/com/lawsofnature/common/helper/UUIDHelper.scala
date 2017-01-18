package com.lawsofnature.common.helper

import java.util.UUID

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object UUIDHelper {
  def generate(): String = UUID.randomUUID.toString.replace("-", "").toUpperCase

  def getXml(map: Map[String, String]): String = {
    val buffer: StringBuilder = new StringBuilder
    buffer.append("<xml>")
    map.foreach {
      e => buffer.append("<").append(e._1).append("><![CDATA[").append(e._2).append("]]></").append(e._1).append(">")
    }
    buffer.append("</xml>")
    buffer.toString
  }
}
