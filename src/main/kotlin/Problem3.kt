import runtime.IGame
import runtime.ImageManager
import java.awt.Color
import java.awt.Graphics
import java.awt.Image

// 問題3
// 画像を使ったプログラミングをしてみましょう。
// 問題2で作成したプログラムをベースに、四角形ではなく人の絵を描画するように変更されています。
// ただし、今のままでは人は前を向いたまま歩き回ることになります。
// プログラムを改造し、歩いた方向にあわせて人の向きが変わるようにしてください。
class Problem3 : IGame() {

    var x: Int = 0
    var y: Int = 0

    // 画像データを読み込む
    // 前向きの画像 front.png の他に、左向きの画像 left.png, 右向きの画像 right.png, 後ろ向きの画像 back.png があります。
    //
    // 座標を保存している変数は var なのに、この画像を保存している変数は val と付けて宣言されています。
    // この違いは var で宣言された変数は内容を書き換えられるけれど、val で宣言した変数は内容を書き換えることが出来ません。
    val front: Image = ImageManager.load("images/problem3/front.png")

    override fun process(pushedKey: Int) {
        // 人をキー入力で動けるようにする
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
        // front 変数に記録された画像を x, y 座標に描画します。
        // 最後の null はおまじないです。深く考えなくていいです。
        g.drawImage(front, x, y, null)
    }
}