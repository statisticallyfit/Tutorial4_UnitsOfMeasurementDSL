lazy val root = (project in file(".")).
  settings(
    name := "UnitsOfMeasurement",
    version := "1.0",
    scalaVersion := "2.12.8"
  )

libraryDependencies += "org.typelevel"  %% "squants"  % "1.3.0"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
