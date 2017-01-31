package com.jxjxgo.common.helper

import java.util.regex.{Matcher, Pattern}

import scala.util.matching.Regex

/**
  * Created by fangzhongwei on 2016/12/5.
  */
object MaskHelper {
  private val regex: Regex = """([0-9]{3})([0-9]{4})([0-9]{4})""".r
  private val EMAIL_REGEX: Pattern = Pattern.compile("^(?<name>[\\S^@]+)@(?<domain>[A-Z0-9.-]+\\.[A-Z]{2,24})$", Pattern.CASE_INSENSITIVE)

  def maskMobile(mobile: String): String = {
    regex.replaceAllIn(mobile, "$1****$3")
  }

  def maskEmailAddress(email: String): String = {
    val matcher: Matcher = EMAIL_REGEX.matcher(email)
    if (matcher.matches) {
      val name: String = matcher.group("name")
      var maskedName: String = null
      if (name.length < 2) maskedName = name
      else if (name.length < 3) maskedName = Masker.maskString(name, 1, 0)
      else if (name.length < 5) maskedName = Masker.maskString(name, 1, 1)
      else maskedName = Masker.maskString(name, 2, 2)

      val domain: String = matcher.group("domain")
      var maskedDomain: String = null
      if (domain.length < 2) maskedName = domain
      else if (domain.length < 3) maskedDomain = Masker.maskString(domain, 1, 0)
      else if (domain.length < 5) maskedDomain = Masker.maskString(domain, 1, 1)
      else maskedDomain = Masker.maskString(domain, 2, 2)

      new StringBuilder(maskedName).append("@").append(maskedDomain).toString()
    }
    else email
  }
}
