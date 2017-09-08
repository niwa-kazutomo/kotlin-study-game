package ansers

import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

class Problem3 : IGame() {

    var x: Int = 0
    var y: Int = 0

    val front: Image = ImageManager.load("images/problem3/front.png")
    val left: Image = ImageManager.load("images/problem3/left.png")
    val right: Image = ImageManager.load("images/problem3/right.png")
    val back: Image = ImageManager.load("images/problem3/back.png")

    var currentImage = front

    override fun process(pushedKey: Int) {
        if(isPushKey(KEY_UP)) {
            y -= 1
            currentImage = back
        }
        if(isPushKey(KEY_DOWN)) {
            y += 1
            currentImage = front
        }
        if(isPushKey(KEY_LEFT)) {
            x -= 1
            currentImage = left
        }
        if(isPushKey(KEY_RIGHT)) {
            x += 1
            currentImage = right
        }
    }

    override fun render(g: Graphics) {
        g.drawImage(currentImage, x, y, null)
    }
}