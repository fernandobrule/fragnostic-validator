package com.fragnostic.validator.glue

import scalaz.ValidationNel

trait UnderValidation {

  type StringValidation[Z] = ValidationNel[String, Z]

}
