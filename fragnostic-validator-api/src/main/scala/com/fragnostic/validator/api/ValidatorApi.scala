package com.fragnostic.validator.api

import scalaz.{ NonEmptyList, ValidationNel }

import java.util.Locale

trait ValidatorApi[T] {

  def doValidation(
    locale: Locale,
    item: T,
    args: Map[String, String] = Map[String, String]()): Either[NonEmptyList[String], T]

}
