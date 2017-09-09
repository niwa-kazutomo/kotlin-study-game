import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

// 問題4
// 次は画面の外に人が出ていかないようにしてみましょう
// 人が画面の外に出ていかないようにする為には、
// x, y の変数の値が画面外になる場合には座標の値を変更しない。というプログラムをする必要があります。
//
// 人の画像の大きさは 幅32ピクセル, 高さ32ピクセル です。
// 右に移動する時と下に移動する時 の画面外に出ていかないようにするプログラムの判定の参考にしてください。
//
// 画面外に出しやすいように移動速度を4倍に変えてあります。
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
                // y の値が 0 よりも大きい場合にだけ y の値をマイナスします。
                y -= 4
                currentImage = back
            }
        }
        if(isPushKey(KEY_DOWN)) {
            y += 4
            currentImage = front
        }
        if(isPushKey(KEY_LEFT)) {
            x -= 4
            currentImage = left
        }
        if(isPushKey(KEY_RIGHT)) {
            x += 4
            currentImage = right
        }
    }

    override fun render(g: Graphics) {
        g.drawImage(currentImage, x, y, null)
    }
}