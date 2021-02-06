package com.fragnostic.validator.api

import java.util.Locale

trait ValidatorApi[T] {

  def validate(t: T, locale: Locale, hasToFormat: Boolean, messages: String*): Validated[T]

}
