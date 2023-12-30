package cn.mucute.merminal.composable

import cn.mucute.merminal.core.TerminalSession.SessionChangedCallback
import cn.mucute.merminal.view.ShellTermSession

class SessionController(
    private val command: String? = null,
    private val currentWorkingDirectory: String,
    private val environment: MutableMap<String, String> = systemEnvironment(),
) {
    fun create(callback: SessionChangedCallback): ShellTermSession {
        val environmentList = mutableListOf<String>()
        environment.forEach { (t, u) ->
            environmentList.add("$t=$u")
        }
        return ShellTermSession(
            "/system/bin/sh",
            currentWorkingDirectory,
            arrayOf(),
            environmentList.toTypedArray(),
            callback,
            command
        )
    }
}
