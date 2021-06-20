package com.fragnostic.validator

import scalaz.{ NonEmptyList, ValidationNel }

package object api {

  type Validated[Z] = ValidationNel[String, Z]

  def nelToList[T](nel: NonEmptyList[T]): List[T] =
    nel.head :: nel.tail.toList

}
