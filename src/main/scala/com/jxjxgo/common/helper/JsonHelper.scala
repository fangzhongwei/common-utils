package com.jxjxgo.common.helper

import java.util

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
  * Created by fangzhongwei on 2016/11/3.
  */
object JsonHelper {
  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
  mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY)

  def writeValueAsString(anyRef: AnyRef): String = mapper.writeValueAsString(anyRef)

  def readByType[T](json: String, c: Class[T]): T = mapper.readValue(json, c)

  def read(json: String, c: Class[_]): AnyRef = mapper.readValue(json, c).asInstanceOf[AnyRef]

  def main(args: Array[String]): Unit = {
//    println(read("[1389356,22,2653,19887,\"茨高\",\"博亞卡捷高\",\"Boyaca Chico\",\"拉尼洛斯\",\"拉尼洛斯\",\"Llaneros FC\",\"08:40\",\"2017,4,23,09,47,39\",-1,3,1,1,0,0,0,4,4,\"5\",\"4\",\"\",\"\",\"\",\"\",\"\",0,0,0,15,\"\",\"\",4,2,1,0]", classOf[util.ArrayList[Object]]))
    println(readByType[util.ArrayList[Object]]("[1389356,22,2653,19887,\"茨高\",\"博亞卡捷高\",\"Boyaca Chico\",\"拉尼洛斯\",\"拉尼洛斯\",\"Llaneros FC\",\"08:40\",\"2017,4,23,09,47,39\",-1,3,1,1,0,0,0,4,4,\"5\",\"4\",\"\",\"\",\"\",\"\",\"\",0,0,0,15,\"\",\"\",4,2,1,0]", classOf[util.ArrayList[Object]]))

  }
}
