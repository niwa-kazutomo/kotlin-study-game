package ansers

import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

class Problem4 : IGame() {

    var x: Int = 0
    var y: Int = 0

    val front: Image = ImageManager.load("images/problem3/front.png")
    val left: Image = ImageManager.load("images/problem3/left.png")
    val right: Image = ImageManager.load("images/problem3/right.png")
    val back: Image = ImageManager.load("images/problem3/back.png")

    var currentImage = front

    override fun process(pushedKey: Int) {
        if(isPushKey(KEY_UP)) {
            if(y > 0) {
                y -= 4
                currentImage = back
            }
        }
        if(isPushKey(KEY_DOWN)) {
            if(y < 600 - 32) {
                y += 4
                currentImage = front
            }
        }
        if(isPushKey(KEY_LEFT)) {
            if(x > 0) {
                x -= 4
                currentImage = left
            }
        }
        if(isPushKey(KEY_RIGHT)) {
            if(x < 800 - 32) {
                x += 4
            }
            currentImage = right
        }
    }

    override fun render(g: Graphics) {
        g.drawImage(currentImage, x, y, null)
    }
}