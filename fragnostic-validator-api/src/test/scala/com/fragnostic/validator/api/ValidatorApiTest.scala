package com.fragnostic.validator.api

import com.fragnostic.validator.validators.{ GiValidator, YepValidator, YumValidator }
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import scalaz.{ Failure, NonEmptyList, Success }

import java.util.Locale

class ValidatorApiTest extends AnyFunSpec with Matchers with BeforeAndAfterEach {

  val yumValidator = new YumValidator()
  val yepValidator = new YepValidator()
  val giValidator = new GiValidator()

  val locale: Locale = new Locale.Builder().setRegion("BR").setLanguage("pt").build()

  val params: Map[String, String] = Map[String, String]()

  val yepValidatorEmptyMessage = "yep.validator.yep.empty"
  val yepValidatorFailMessage = "yep.validator.i.am.not.yep"
  val yumValidatorEmptyMessage = "yep.validator.yum.empty"
  val yumValidatorFailMessage = "yep.validator.i.am.not.yum"
  val giValidatorEmptyMessage = "yep.validator.gi.empty"
  val giValidatorFailMessage = "yep.validator.i.am.not.gi"

  describe("*** Validator Api Test ***") {

    it("Can Validate Yep") {
      val yep = "I am Yep"
      val validation: Validated[String] = yepValidator.validate(yep, locale, params, List(yepValidatorEmptyMessage, yepValidatorFailMessage))
      validation.isSuccess should be(true)
      validation.toList.head should be(yep)
    }

    it("Can Validate Wrong Yep") {
      val yep = "I am peY"
      val validation: Validated[String] = yepValidator.validate(yep, locale, params, List(yepValidatorEmptyMessage, yepValidatorFailMessage))
      validation.isFailure should be(true)

      (validation match {
        case Failure(f) =>
          f match {
            case NonEmptyList(a, value) => a
            case _ =>
          }
        case Success(s) =>
      }) should be(yepValidatorFailMessage)

    }

    it("Can Validate Wrong Number Of Arguments, Less Than") {
      val yep = "I am peY"
      val validation: Validated[String] = yepValidator.validate(yep, locale, params, List(yepValidatorEmptyMessage))
      validation.isFailure should be(true)

      (validation match {
        case Failure(f) =>
          f match {
            case NonEmptyList(a, value) => a
            case _ =>
          }
        case Success(s) =>
      }) should be("yep.validator.number.of.args.lt")

    }

    it("Can Validate Wrong Number Of Arguments, Great Than") {
      val yep = "I am peY"
      val validation: Validated[String] = yepValidator.validate(yep, locale, params, List(yepValidatorEmptyMessage, yepValidatorEmptyMessage, yepValidatorEmptyMessage))
      validation.isFailure should be(true)

      (validation match {
        case Failure(f) =>
          f match {
            case NonEmptyList(a, value) => a
            case _ =>
          }
        case Success(s) =>
      }) should be("yep.validator.number.of.args.gt")

    }

    it("Can Validate Yum") {
      val yum = "I am Yum"
      val params: Map[String, String] = Map[String, String]()
      val validation: Validated[String] = yumValidator.validate(yum, locale, params, List(yumValidatorEmptyMessage, yumValidatorFailMessage))
      validation.isSuccess should be(true)
      validation.toList.head should be(yum)
    }

    it("Can Validate Gi") {
      val gi = "I am Gi"
      val validation: Validated[String] = giValidator.validate(gi, locale, params, List(giValidatorEmptyMessage, giValidatorFailMessage))
      validation.isSuccess should be(true)
      validation.toList.head should be(gi)
    }

  }

}
