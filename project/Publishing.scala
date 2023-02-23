import sbt.Keys._
import sbt._
import xerial.sbt.Sonatype.autoImport._

/** sbt publish setting
 *
 *  @author
 *    梦境迷离
 *  @since 2020-07-19
 *  @version v1.0
 */
object Publishing {

  lazy val publishSettings = Seq(
    isSnapshot := version.value endsWith "SNAPSHOT",
    credentials += Credentials(Path.userHome / ".ivy2" / ".bitlap_sonatype_credentials"),
    ThisBuild / publishTo := {
      val nexus = "https://s01.oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
    },
    licenses               := Seq(License.MIT),
    publishMavenStyle      := true,
    Test / publishArtifact := false,
    pomIncludeRepository   := { _ => false },
    developers := List(
      Developer(
        id = "dreamylost",
        name = "梦境迷离",
        email = "dreamylost@outlook.com",
        url = url("https://dreamylost.cn")
      )
    ),
    sonatypeProfileName := organization.value,
    homepage            := Some(url("https://github.com/bitlap/bitlapx")),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/bitlap/bitlapx"),
        "scm:git@github.com:bitlap/smt.git"
      )
    )
  )
}
