package com.lawsofnature.common.helper

import java.util.UUID

/**
  * Created by fangzhongwei on 2017/1/18.
  */
object UUIDHelper {
  def generate(): String = UUID.randomUUID.toString.replace("-", "").toUpperCase
}
