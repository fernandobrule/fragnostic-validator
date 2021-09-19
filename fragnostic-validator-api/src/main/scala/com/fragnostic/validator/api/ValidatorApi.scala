package com.fragnostic.validator.api

import com.fragnostic.i18n.api.ResourceI18n

import java.util.Locale

trait ValidatorApi[T] {

  def validate(
    locale: Locale,
    i18n: ResourceI18n,
    domain: String,
    t: T,
    params: Map[String, String] = Map.empty,
    messages: Map[String, String] = Map.empty,
    mandatory: Boolean = true //
  ): Validated[T]

}
