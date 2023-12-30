package cn.mucute.merminal.composable

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

object TerminalDefaults {
    @Composable
    fun terminalColors(
        text: Color = LocalContentColor.current,
        background: Color = MaterialTheme.colorScheme.surface,
        cursor: Color = MaterialTheme.colorScheme.primary
    ) = TerminalColorScheme(text, background, cursor)
}

@Immutable
data class TerminalColorScheme(
    val text: Color,
    val background: Color,
    val cursor: Color
)