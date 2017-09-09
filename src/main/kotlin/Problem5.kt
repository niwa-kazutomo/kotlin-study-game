import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

// 問題5
// 次は1枚の画像を一部分だけ切り出して使ってみましょう。
// これまでは front / left / right / back の4枚の画像を使用してきましたが、
// この問題では以下の配置で1枚の画像に4種類の画像が保存されています。
//
//      | 32px  | 32px | 32px  | 32px |
// -----+-------+------+-------+------+
// 32px | front | left | right | back |
// -----+-------+------+-------+------+
class Problem5 : IGame() {

    var x: Int = 0
    var y: Int = 0

    val image: Image = ImageManager.load("images/problem5/image.png")

    val CHARACTER_WIDTH = 32
    val CHARACTER_HEIGHT = 32

    override fun process(pushedKey: Int) {
        if(isPushKey(KEY_UP)) {
            if(y > 0) {
                y -= 4
            }
        }
        if(isPushKey(KEY_DOWN)) {
            if(y < 600 - CHARACTER_HEIGHT) {
                y += 4
            }
        }
        if(isPushKey(KEY_LEFT)) {
            if(x > 0) {
                x -= 4
            }
        }
        if(isPushKey(KEY_RIGHT)) {
            if(x < 800 - CHARACTER_WIDTH) {
                x += 4
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
                0, // 画像切り取り開始位置 X座標
                0, // 画像切り取り開始位置 Y座標
                CHARACTER_WIDTH, // 画像切り取り終了位置 X座標
                CHARACTER_HEIGHT, // 画像切り取り終了位置 Y座標
                null)
    }
}