package com.fragnostic.validator.api

import scalaz.ValidationNel

trait ValidatorApi[T] {

  type Validated[Z] = ValidationNel[String, Z]

  def validate(t: T, hasToFormat: Boolean, messages: String*): Validated[String]

}
