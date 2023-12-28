package cn.mucute.merminal.view

import cn.mucute.merminal.core.TerminalSession

class ShellTermSession(
  shellPath: String,
  cwd: String,
  args: Array<String>,
  env: Array<String>,
  changeCallback: SessionChangedCallback?,
  private val initialCommand: String?,
) : TerminalSession(shellPath, cwd, args, env, changeCallback) {

  private var exitPrompt = "按回车关闭"

  override fun initializeEmulator(columns: Int, rows: Int) {
    super.initializeEmulator(columns, rows)
    sendInitialCommand(initialCommand)
  }

  override fun getExitDescription(exitCode: Int): String {
    val builder = StringBuilder("\r\n[")
    builder.append("进程已结束")
    if (exitCode > 0) {
      // Non-zero process exit.
      builder.append(" (")
      builder.append("状态:$exitCode")
      builder.append(")")
    } else if (exitCode < 0) {
      // Negated signal.
      builder.append(" (")
      builder.append("信号"+( -exitCode))
      builder.append(")")
    }
    builder.append(" - $exitPrompt]")
    return builder.toString()
  }

  private fun sendInitialCommand(command: String?) {
    if (command?.isNotEmpty() == true) {
      write(command + '\r')
    }
  }
}
