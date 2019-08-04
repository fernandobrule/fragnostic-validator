import sbt._
import Keys._

object Dependencies {
    
  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime"
  lazy val slf4jApi = "org.slf4j" % "slf4j-api" % "1.7.26"
  lazy val scalatest = "org.scalatest" %% "scalatest" % "3.0.8" % "test"
  lazy val fragnosticI18n = "com.fragnostic" % "fragnostic-i18n_2.13" % "0.1.11-SNAPSHOT"
  
}
