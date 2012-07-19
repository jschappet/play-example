
import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {
  val appName = "play-example"
  val appVersion = "0.0.1"

  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
    (base / "app" / "assets" / "stylesheets" * "*.less")
  )

  val appDependencies: Seq[sbt.ModuleID] = Seq(
  			"org.scalatest" %% "scalatest" % "1.8" % "test",
			"org.squeryl" %% "squeryl" % "0.9.5-2",
        	"postgresql" % "postgresql" % "9.1-901.jdbc4"
		)

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    lessEntryPoints <<= baseDirectory(customLessEntryPoints),
    organization := "edu.uiowa.icts",
    testOptions in Test := Nil

    

    )

}
