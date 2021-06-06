package com.fragnostic.validator.api

import java.util.Locale

trait ValidatorApi[T] {

  def validate(t: T, locale: Locale, params: Map[String, String], messages: List[String] = Nil): Validated[T]

}
