package com.lawsofnature.common.helper

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

/**
  * Created by fangzhongwei on 2016/11/3.
  */
object JsonHelper {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
  mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)

  def writeValueAsString(anyRef: AnyRef): String = {
    mapper.writeValueAsString(anyRef)
  }

  def readByType[T](json: String, c: Class[T]): T = {
    mapper.readValue(json, c)
  }

  def read(json: String, c: Class[_]): AnyRef = {
    mapper.readValue(json, c).asInstanceOf[AnyRef]
  }
}
