package cn.mucute.merminal.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.viewinterop.AndroidView
import cn.mucute.merminal.view.TermSessionCallback
import cn.mucute.merminal.view.TermViewClient
import cn.mucute.merminal.view.TerminalView

@Composable
fun Terminal(modifier: Modifier = Modifier, sessionController: SessionController) {
    val context = LocalContext.current
    val current = LocalFocusManager.current
    val focusRequester = FocusRequester()
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    AndroidView(factory = {
        TerminalView(context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
        }
    }, modifier = modifier.focusRequester(focusRequester), update = {
        it.setBackgroundColor(0xFF212121.toInt())
        val sessionCallback = TermSessionCallback(it)
        val session = sessionController.create(sessionCallback)
        val viewClient = TermViewClient(context, it, session)
        it.setEnableWordBasedIme(false)
        it.setTerminalViewClient(viewClient)
        it.attachSession(session)
        it.requestFocus()
    })
}
@Composable
fun rememberSessionController(
    command: String? = null,
    currentWorkingDirectory: String,
    environment: MutableMap<String,String> = systemEnvironment(),
) = remember(command, currentWorkingDirectory, environment) {
    SessionController(
        command,
        currentWorkingDirectory,
        environment
    )
}
fun systemEnvironment() = mutableMapOf(
    "TERM" to "xterm-256color",
    "ANDROID_ROOT" to System.getenv("ANDROID_ROOT")!!,
    "ANDROID_DATA" to System.getenv("ANDROID_DATA")!!,
    "COLORTERM" to "truecolor",
)