package com.fragnostic.validator

import scalaz.ValidationNel

package object api {

  type Validated[Z] = ValidationNel[String, Z]

}
