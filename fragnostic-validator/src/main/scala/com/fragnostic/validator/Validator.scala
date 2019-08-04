package com.fragnostic.validator

import java.util.Locale

import scala.collection.mutable.ListBuffer

trait Validator[T] {

  def doValidation(
    locale: Locale,
    item: T,
    args: Map[String, String] = Map[String, String]()): Either[List[String], T]

  def addError(error: String): List[String]

  def addAllErrors(errors: ListBuffer[String]): List[String]

  def addAllErrors(errors: List[String]): List[String]

  def getErrors: List[String]

  def reset(): Unit

}
