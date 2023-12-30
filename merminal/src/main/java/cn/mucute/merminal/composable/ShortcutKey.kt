package cn.mucute.merminal.composable

import android.view.KeyEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.KeyboardArrowDown
import androidx.compose.material.icons.twotone.KeyboardArrowLeft
import androidx.compose.material.icons.twotone.KeyboardArrowRight
import androidx.compose.material.icons.twotone.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ShortcutKeyController {
    var pressedCtrlKey by mutableStateOf(false)
    var pressedAltKey by mutableStateOf(false)
}

@Composable
fun ShortcutKey(
    modifier: Modifier = Modifier,
    shortcutKeyController: ShortcutKeyController,
    onWriteSymbol: (String) -> Unit,
    onPressKey: (Int) -> Unit
) {
    val scope = rememberCoroutineScope()
    Column(modifier = modifier) {
        Row {
            ShortcutKeyItem(modifier = Modifier.weight(1f), content = { Text("Esc") }, onClick = {
                onPressKey(KeyEvent.KEYCODE_ESCAPE)
            })
            ShortcutKeyItem(modifier = Modifier.weight(1f), content = { Text("Tab") }, onClick = {
                onPressKey(KeyEvent.KEYCODE_TAB)
            })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("Kill") },
                onClick = {
//                    shortcutKeyController.pressedCtrlKey = true
//                    scope.launch {
//                        onWriteSymbol("c")
//                    }
////                    shortcutKeyController.pressedCtrlKey = false
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Icon(Icons.TwoTone.KeyboardArrowUp, contentDescription = null) },
                onClick = {
                    onPressKey(KeyEvent.KEYCODE_DPAD_UP)
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("-") },
                onClick = { onWriteSymbol("-") })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("/") },
                onClick = { onWriteSymbol("/") })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("\\") },
                onClick = { onWriteSymbol("\\") })
        }
        Row {
            ShortcutKeyItem(
                modifier = Modifier
                    .weight(1f)
                    .then(
                        if (shortcutKeyController.pressedCtrlKey) Modifier.background(
                            MaterialTheme.colorScheme.primary.copy(
                                0.3f
                            )
                        ) else Modifier
                    ),
                content = { Text("Ctrl") },
                onClick = {
                    shortcutKeyController.pressedCtrlKey = !shortcutKeyController.pressedCtrlKey
                })

            ShortcutKeyItem(
                modifier = Modifier
                    .weight(1f)
                    .then(
                        if (shortcutKeyController.pressedAltKey) Modifier.background(
                            MaterialTheme.colorScheme.primary.copy(
                                0.3f
                            )
                        ) else Modifier
                    ),
                content = { Text("Alt") },
                onClick = {
                    shortcutKeyController.pressedAltKey = !shortcutKeyController.pressedAltKey
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Icon(Icons.TwoTone.KeyboardArrowLeft, contentDescription = null) },
                onClick = {
                    onPressKey(KeyEvent.KEYCODE_DPAD_LEFT)
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Icon(Icons.TwoTone.KeyboardArrowDown, contentDescription = null) },
                onClick = {
                    onPressKey(KeyEvent.KEYCODE_DPAD_DOWN)
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Icon(Icons.TwoTone.KeyboardArrowRight, contentDescription = null) },
                onClick = {
                    onPressKey(KeyEvent.KEYCODE_DPAD_RIGHT)
                })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("$") },
                onClick = { onWriteSymbol("$") })
            ShortcutKeyItem(
                modifier = Modifier.weight(1f),
                content = { Text("|") },
                onClick = { onWriteSymbol("|") })
        }
    }
}

@Composable
fun ShortcutKeyItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Box(
        modifier
            .height(40.dp)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {
        content()
    }
}