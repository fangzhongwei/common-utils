package com.jxjxgo.common.helper

/**
  * Created by fangzhongwei on 2016/12/7.
  */
object Masker {
  val maskChar: Char = '*'

  def maskString(str: String, unmaskedCharsAtStart: Int, unmaskedCharsAtEnd: Int): String = {
    val builder: StringBuilder = new StringBuilder(str)
    if (str.length > (unmaskedCharsAtStart + unmaskedCharsAtEnd)) {
      var i: Int = unmaskedCharsAtStart
      while (i < str.length - unmaskedCharsAtEnd) {
        builder.setCharAt(i, maskChar)
        i += 1
        i - 1
      }
    }
    else throw new RuntimeException(String.format("Length (%s) of string \"%s\" is too short for specified number of unmasked characters (%s).", str.length.asInstanceOf[AnyRef], str, (unmaskedCharsAtStart + unmaskedCharsAtEnd).asInstanceOf[AnyRef]))
    builder.toString
  }
}
