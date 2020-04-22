ThisBuild / scalaVersion := "2.12.11"

lazy val exercise1 = project
  .in(file("exercises/exercise1"))

lazy val exercise2 = project
  .in(file("exercises/exercise2"))

lazy val exercise3 = project
  .in(file("exercises/exercise3"))

lazy val exercise4 = project
  .in(file("exercises/exercise4"))

lazy val exercise5 = project
  .in(file("exercises/exercise5"))
  .dependsOn(exercise3)
  .settings(
    libraryDependencies += "org.typelevel" %% "cats-core" % "1.1.0"
  )

lazy val exampleScalacheck = project
  .in(file("examples/scalacheck"))
  .dependsOn(exercise3)
  .settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "1.6.0",
      "org.scalacheck" %% "scalacheck" % "1.13.4"
    )
  )


lazy val docs = project
  .in(file("docs"))
  .settings(
    Tut / scalacOptions ++= Seq(
      "-encoding", "UTF-8", // 2 args
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions"
    ),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.5"),
    tutSourceDirectory := baseDirectory.value / "tut",
    tutTargetDirectory := baseDirectory.value / "tut-out",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4")
  .enablePlugins(TutPlugin)
