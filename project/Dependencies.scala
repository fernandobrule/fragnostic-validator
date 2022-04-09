import sbt._

object Dependencies {

  lazy val fragnosticI18nImpl      = "com.fragnostic"        % "fragnostic-i18n-impl_2.13"    % "0.2.5"

  lazy val logbackClassic          = "ch.qos.logback"        % "logback-classic"              % "1.3.0-alpha12" % "runtime"
  lazy val scalatestFunSpec        = "org.scalatest"        %% "scalatest-funspec"            % "3.3.0-SNAP3" % Test
  lazy val scalazCore              = "org.scalaz"            % "scalaz-core_2.13"             % "7.4.0-M9"

}
