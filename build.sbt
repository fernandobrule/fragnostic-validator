import com.typesafe.sbt.pgp.PgpKeys
import Dependencies._

val unusedOptions = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 11)) =>
      Seq("-Ywarn-unused-import")
    case _ =>
      Seq("-Ywarn-unused:imports")
  }
)

lazy val fragnosticSettings = Seq(
  organization := "com.fragnostic",
  crossScalaVersions := Seq("2.12.8", "2.11.12", "2.13.0"),
  scalaVersion := crossScalaVersions.value.head,
  scalacOptions ++= unusedOptions.value,
  scalacOptions ++= Seq(
    "-target:jvm-1.8",
    "-unchecked",
    "-deprecation",
    "-Xlint",
    /*"-Yinline-warnings",*/
    "-Xcheckinit",
    "-encoding", "utf8",
    "-feature",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-language:reflectiveCalls",
    "-language:existentials"
  ),
  manifestSetting,
  dependencyOverrides := Seq(
    "org.scala-lang" % "scala-library"  % scalaVersion.value,
    "org.scala-lang" % "scala-reflect"  % scalaVersion.value,
    "org.scala-lang" % "scala-compiler" % scalaVersion.value
  )
) ++ Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedOptions.value
)

lazy val fragnosticProject = Project(
  id = "fragnostic-validator-project",
  base = file(".")).settings(
    fragnosticSettings ++ Seq(
    name := "fragnostic-validator",
    artifacts := Classpaths.artifactDefs(Seq(packageDoc in Compile, makePom in Compile)).value,
    packagedArtifacts := Classpaths.packaged(Seq(packageDoc in Compile, makePom in Compile)).value,
    description := "fragnostic-validator",
    shellPrompt := { state =>
      s"sbt:${Project.extract(state).currentProject.id}" + Def.withColor("> ", Option(scala.Console.CYAN))
    }
  )).aggregate(
    fragnosticValidator
  ).enablePlugins()
 
lazy val manifestSetting = packageOptions += {
  Package.ManifestAttributes(
    "Created-By" -> "Simple Build Tool",
    "Built-By" -> System.getProperty("user.name"),
    "Build-Jdk" -> System.getProperty("java.version"),
    "Specification-Title" -> name.value,
    "Specification-Version" -> version.value,
    "Specification-Vendor" -> organization.value,
    "Implementation-Title" -> name.value,
    "Implementation-Version" -> version.value,
    "Implementation-Vendor-Id" -> organization.value,
    "Implementation-Vendor" -> organization.value
  )
}

lazy val doNotPublish = Seq(publish := {}, publishLocal := {}, PgpKeys.publishSigned := {}, PgpKeys.publishLocalSigned := {})

lazy val fragnosticValidator = Project(
  id = "fragnostic-validator",
  base = file("fragnostic-validator")).settings(fragnosticSettings ++ Seq(
    libraryDependencies ++= Seq(
      logbackClassic,
      slf4jApi,
      scalatest,
      fragnosticI18n
    ),
    description := "fragnostic-validator"
  )
) dependsOn(
)
