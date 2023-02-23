import sbt.Command

/** @author
 *    梦境迷离
 *  @since 2022/1/15
 *  @version 1.0
 */
object Commands {

  val FmtSbtCommand = Command.command("fmt")(state => "scalafmtSbt" :: "scalafmtAll" :: state)

  val FixSbtCommand = Command.command("fix")(state => "scalafixEnable" :: state)

  val FmtSbtCheckCommand =
    Command.command("check")(state =>
      "scalafixEnable" :: "scalafixAll --check" :: "scalafmtSbtCheck" :: "scalafmtCheckAll" :: state
    )

  val value = Seq(
    FmtSbtCommand,
    FmtSbtCheckCommand,
    FixSbtCommand
  )

}
