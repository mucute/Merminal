package cn.mucute.merminal.view

import cn.mucute.merminal.core.TerminalSession

class TermSessionCallback(private var terminalView: TerminalView) : TerminalSession.SessionChangedCallback {

  override fun onTextChanged(changedSession: TerminalSession?) {
    terminalView.onScreenUpdated()
  }

  override fun onTitleChanged(changedSession: TerminalSession?) {

  }

  override fun onSessionFinished(finishedSession: TerminalSession?) {

  }

  override fun onClipboardText(session: TerminalSession?, text: String?) {

  }

  override fun onColorsChanged(session: TerminalSession?) {
    terminalView.onScreenUpdated()
  }
}
