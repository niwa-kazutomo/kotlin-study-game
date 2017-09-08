import runtime.IGame
import java.awt.Color
import java.awt.Graphics

// 問題1
// プログラミングを体験してみよう。
// 下のプログラムは 画面の左上に 幅50ピクセル×高さ50ピクセル の赤い四角形を描画するプログラムです。
// コメントをよく読んで、色を変えたり描画される位置や大きさを変えてみましょう。
class Problem1 : IGame() {

    override fun process(pushedKey: Int) {

    }

    override fun render(g: Graphics) {
        // 描画する四角形の色を指定します。
        // RED を指定していると、赤色の四角形が描画されます。
        // 他にも BLUE や GREEN。BLACK といった値が指定できます。
        // 値を書き換えて、色が変わることを確認してみましょう。
        g.color = Color.RED

        // 四角形を描画します。
        // 4つの引数（ひきすう/パラメータ）を受け取ります。
        // x, y には四角形を描画する座標（ざひょう/位置）を指定します。
        // x は横の位置。y は縦の位置を指し、左上が x=0, y=0。右下が x=800, y=600 です。
        // width, height には四角形の大きさを指定します。
        // width は四角形の幅を、height は四角形の高さを指定します。
        // x, y で指定した座標から右下に向かって四角形を描画します。
        g.fillRect(0, 0, 50, 50)
    }
}