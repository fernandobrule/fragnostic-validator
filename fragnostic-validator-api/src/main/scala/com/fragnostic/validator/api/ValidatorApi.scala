package com.fragnostic.validator.api

import java.util.Locale

trait ValidatorApi[T] {

  def validate(
    locale: Locale,
    domain: String,
    t: T,
    params: Map[String, String] = Map.empty,
    messages: Map[String, String] = Map.empty,
    mandatory: Boolean = true //
  ): Validated[T]

}
