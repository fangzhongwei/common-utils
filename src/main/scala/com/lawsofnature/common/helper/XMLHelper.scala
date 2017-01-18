package com.lawsofnature.common.helper

import scala.xml.Elem

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object XMLHelper {
  def fromString(str: String): Elem = {
    scala.xml.XML.loadString(str)
  }
}
