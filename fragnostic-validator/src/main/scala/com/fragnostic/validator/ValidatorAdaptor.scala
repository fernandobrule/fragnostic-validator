package com.fragnostic.validator

import java.util.Locale

import com.fragnostic.i18n.MessageI18n

import scala.collection.mutable.ListBuffer

trait ValidatorAdaptor[T] extends Validator[T] {

  private val errors: ListBuffer[String] = ListBuffer[String]()

  def valida(locale: Locale, i18n: MessageI18n, text: String, maxLength: Int, keyForEmpty: String, keyForExLg: String): List[String] =
    if (Option(text).isEmpty)
      addError(i18n.getString(locale, keyForEmpty))
    else if (text.trim.isEmpty)
      addError(i18n.getString(locale, keyForEmpty))
    else if (text.trim.length > maxLength)
      addError(i18n.getFormattedString(locale, keyForExLg, List(text.trim, text.trim.length.toString, maxLength.toString)))
    else Nil

  def getErrors: List[String] = {
    errors.toList
  }

  def addError(error: String): List[String] = {
    errors += error
    errors.toList
  }

  def addAllErrors(errors_ : List[String]): List[String] = {
    errors ++= errors_
    errors.toList
  }

  def addAllErrors(errors_ : ListBuffer[String]): List[String] = {
    errors ++= errors_
    errors.toList
  }

  def reset(): Unit =
    errors.clear()

}
