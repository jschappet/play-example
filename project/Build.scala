
import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {
  val appName = "project-play2"
  val appVersion = "0.0.1"

  val appDependencies: Seq[sbt.ModuleID] = Seq(
                "postgresql" % "postgresql" % "9.1-901.jdbc4"
		)

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    organization := "edu.uiowa.icts")

	
}
