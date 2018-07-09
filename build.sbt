scalaVersion := "2.12.4"

scalacOptions ++= Seq(
  "-encoding", "UTF-8", // 2 args
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard"
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.5")

enablePlugins(TutPlugin)

tutSourceDirectory := baseDirectory.value / "tut"

tutTargetDirectory := baseDirectory.value / "tut-out"
