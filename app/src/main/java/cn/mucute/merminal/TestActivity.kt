package cn.mucute.merminal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
                }, command = "ping 127.0.0.1"
            )
            MaterialTheme {
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surface)
                        .fillMaxSize()
                ) {
                    Terminal(sessionController = sessionController)
                }
            }
        }
    }

}
