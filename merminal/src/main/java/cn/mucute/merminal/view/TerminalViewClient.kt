package cn.mucute.merminal.view

import android.view.KeyEvent
import android.view.MotionEvent
import cn.mucute.merminal.core.TerminalSession

/**
 * Input and scale listener which may be set on a [TerminalView] through
 * [TerminalView.setTerminalViewClient].
 *
 *
 */
interface TerminalViewClient {
    /**
     * Callback function on scale events according to [ScaleGestureDetector.getScaleFactor].
     */
    fun onScale(scale: Float): Float

    /**
     * On a single tap on the terminal if terminal mouse reporting not enabled.
     */
    fun onSingleTapUp(e: MotionEvent?)
    fun shouldBackButtonBeMappedToEscape(): Boolean
    fun copyModeChanged(copyMode: Boolean)
    fun onKeyDown(keyCode: Int, e: KeyEvent?, session: TerminalSession?): Boolean
    fun onKeyUp(keyCode: Int, e: KeyEvent?): Boolean
    fun readControlKey(): Boolean
    fun readAltKey(): Boolean
    fun onCodePoint(codePoint: Int, ctrlDown: Boolean, session: TerminalSession?): Boolean
    fun onLongPress(event: MotionEvent?): Boolean
}
