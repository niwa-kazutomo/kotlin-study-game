package answer

import runtime.IGame
import java.awt.Color
import java.awt.Graphics

class Problem2 : IGame() {

    var x: Int = 0
    var y: Int = 0

    override fun process(pushedKey: Int) {
        if(isPushKey(KEY_UP)) {
            y -= 1
        }
        if(isPushKey(KEY_DOWN)) {
            y += 1
        }
        if(isPushKey(KEY_LEFT)) {
            x -= 1
        }
        if(isPushKey(KEY_RIGHT)) {
            x += 1
        }
    }

    override fun render(g: Graphics) {
        g.color = Color.RED
        g.fillRect(x, y, 50, 50)
    }
}