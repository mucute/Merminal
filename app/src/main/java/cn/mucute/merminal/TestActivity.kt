package cn.mucute.merminal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cn.mucute.merminal.composable.Terminal
import cn.mucute.merminal.composable.rememberSessionController

class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sessionController = rememberSessionController(
                currentWorkingDirectory = "/data/data/cn.mucute.merinal/files",
                environment = cn.mucute.merminal.composable.systemEnvironment().apply {
                    put("HOME", "/data/data/cn.mucute.merinal/files")
                }
            )
            Terminal(sessionController = sessionController)
        }
    }

}
