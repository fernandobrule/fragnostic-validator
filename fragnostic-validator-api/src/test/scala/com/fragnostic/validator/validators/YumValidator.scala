package com.fragnostic.validator.validators

import com.fragnostic.validator.api.{ Validated, ValidatorApi }
import scalaz.Scalaz._

import java.util.Locale

class YumValidator extends ValidatorApi[String] {

  override def validate(locale: Locale, domain: String, yum: String, params: Map[String, String], messages: List[String], mandatory: Boolean = true): Validated[String] =
    if (messages.length < 2) {
      "yum.validator.number.of.args.lt".failureNel
    } else if (messages.length > 2) {
      "yum.validator.number.of.args.gt".failureNel
    } else if (yum.trim.isEmpty) {
      messages.head.failureNel // "yum.validator.yum.empty"
    } else if (!yum.toLowerCase.contains("yum")) {
      messages(1).failureNel // "yum.validator.i.am.not.yum"
    } else {
      yum.trim.successNel
    }

}

