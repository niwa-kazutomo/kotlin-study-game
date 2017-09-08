package runtime

import java.awt.Graphics
import java.awt.event.KeyEvent

abstract class IGame {

    val keyState = HashMap<Int, Boolean>()

    val KEY_UP = KeyEvent.VK_UP
    val KEY_DOWN = KeyEvent.VK_DOWN
    val KEY_LEFT = KeyEvent.VK_LEFT
    val KEY_RIGHT = KeyEvent.VK_RIGHT
    val KEY_Z = KeyEvent.VK_Z
    val KEY_X = KeyEvent.VK_X
    val KEY_A = KeyEvent.VK_A
    val KEY_S = KeyEvent.VK_S

    abstract fun process(pushedKey: Int);

    abstract fun render(g: Graphics)

    fun updateKeyState(keyState: Map<Int, Boolean>) {
        this.keyState.putAll(keyState)
    }

    fun isPushKey(keyCode: Int): Boolean {
        if(this.keyState.containsKey(keyCode)) {
            return this.keyState[keyCode] ?: return false
        }
        return false
    }
}