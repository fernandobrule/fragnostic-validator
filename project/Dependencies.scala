import sbt._

object Dependencies {

  lazy val fragnosticI18nImpl      = "com.fragnostic"        % "fragnostic-i18n-impl_2.13"    % "0.2.8"
  lazy val logbackClassic          = "ch.qos.logback"        % "logback-classic"              % "1.5.0" % "runtime"
  lazy val scalatestFunSpec        = "org.scalatest"        %% "scalatest-funspec"            % "3.2.18" % Test
  lazy val scalazCore              = "org.scalaz"            % "scalaz-core_2.13"             % "7.3.8"

}
