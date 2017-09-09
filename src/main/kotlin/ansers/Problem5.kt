package ansers

import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

class Problem5 : IGame() {

    var x: Int = 0
    var y: Int = 0

    val image: Image = ImageManager.load("images/problem5/image.png")

    val CHARACTER_WIDTH = 32
    val CHARACTER_HEIGHT = 32

    var clipX = 0

    override fun process(pushedKey: Int) {
        if(isPushKey(KEY_UP)) {
            if(y > 0) {
                y -= 4
                clipX = 96
            }
        }
        if(isPushKey(KEY_DOWN)) {
            if(y < 600 - CHARACTER_HEIGHT) {
                y += 4
                clipX = 0
            }
        }
        if(isPushKey(KEY_LEFT)) {
            if(x > 0) {
                x -= 4
                clipX = 32
            }
        }
        if(isPushKey(KEY_RIGHT)) {
            if(x < 800 - CHARACTER_WIDTH) {
                x += 4
                clipX = 64
            }
        }
    }

    override fun render(g: Graphics) {
        g.drawImage(
                image, // 描画する画像
                x, // 描画開始位置 X座標
                y, // 描画開始位置 Y座標
                x + CHARACTER_WIDTH, // 描画終了位置 X座標
                y + CHARACTER_HEIGHT, // 描画終了位置 Y座標
                clipX, // 画像切り取り開始位置 X座標
                0, // 画像切り取り開始位置 Y座標
                clipX + CHARACTER_WIDTH, // 画像切り取り終了位置 X座標
                CHARACTER_HEIGHT, // 画像切り取り終了位置 Y座標
                null)
    }
}