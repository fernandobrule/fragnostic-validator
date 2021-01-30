package com.fragnostic.validator.api

import java.util.Locale
import scalaz.NonEmptyList

trait ValidatorApi[T] {

  def doValidation(
    locale: Locale,
    item: T,
    args: Map[String, String] = Map[String, String]()): Either[NonEmptyList[String], T]

}
