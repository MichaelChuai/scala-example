name := """webcage"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers ++= Seq(
  "Websudos releases" at "https://dl.bintray.com/websudos/oss-releases/"
)

libraryDependencies += "com.websudos" % "phantom-dsl_2.11" % "1.20.0"

libraryDependencies += "joda-time" % "joda-time" % "2.9.1"


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
