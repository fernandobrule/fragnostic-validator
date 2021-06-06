package com.fragnostic.validator.validators

import com.fragnostic.validator.api.{ Validated, ValidatorApi }
import scalaz.Scalaz._

import java.util.Locale

class YepValidator extends ValidatorApi[String] {

  override def validate(yep: String, locale: Locale, params: Map[String, String], messages: List[String]): Validated[String] =
    if (messages.length < 2) {
      "yep.validator.number.of.args.lt".failureNel
    } else if (messages.length > 2) {
      "yep.validator.number.of.args.gt".failureNel
    } else {
      if (yep.trim.isEmpty) {
        messages(0).failureNel // "yep.validator.yep.empty"
      } else if (!yep.toLowerCase.contains("yep")) {
        messages(1).failureNel // "yep.validator.i.am.not.yep"
      } else {
        yep.trim.successNel
      }
    }

}
