package com.fragnostic.validator.validators

import com.fragnostic.validator.api.{ Validated, ValidatorApi }
import scalaz.Scalaz._

import java.util.Locale

class GiValidator extends ValidatorApi[String] {

  override def validate(locale: Locale, domain: String, gi: String, params: Map[String, String], messages: List[String], mandatory: Boolean = true): Validated[String] =
    if (messages.length < 2) {
      "gi.validator.number.of.args.lt".failureNel
    } else if (messages.length > 2) {
      "gi.validator.number.of.args.gt".failureNel
    } else if (gi.trim.isEmpty) {
      messages.head.failureNel // "gi.validator.gi.empty"
    } else if (!gi.toLowerCase.contains("gi")) {
      messages(1).failureNel // "gi.validator.i.am.not.gi"
    } else {
      gi.trim.successNel
    }

}

