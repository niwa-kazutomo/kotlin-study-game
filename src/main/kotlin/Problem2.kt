import runtime.IGame
import java.awt.Color
import java.awt.Graphics

// 問題2
// キーの入力にあわせて四角形を動かしてみよう。
// 初期状態では カーソルの下キー を押したときに四角形が下に動くようプログラミングされています。
// 改造して上下左右自在に動き回るようにしてください。
class Problem2 : IGame() {

    // これは変数(へんすう)です
    // 変数とは数値などをいれるデータの入れ物です。
    // 今回は x, y という2つの変数を用意し、それぞれに Int という種類のデータを入れられるようにしています。
    // Int とは 整数値（小数部をもたない数字）を入れられる場所として宣言し、最初の値は 0 と指定しています。
    var x: Int = 0
    var y: Int = 0

    override fun process(pushedKey: Int) {
        // ゲームは1秒間に60回画面を描画します。
        // ここは描画する前に1回呼び出される場所で、1秒間に60回呼び出されます。

        if(isPushKey(KEY_DOWN)) {
            // 下ボタンが押されていたらこの括弧の中の処理を実行します。
            // これは y の値を +1 する という処理です。
            // y を +1 することで、四角形が描画される位置が下に移動します
            y += 1
        }

        // =======================================================================================
        // ここに KEY_UP / KEY_LEFT / KEY_RIGHT を指定した場合の処理を追加して、四角形を動かしてみましょう。
        // =======================================================================================
    }

    override fun render(g: Graphics) {
        // 先程のサンプルとは異なり、描画する x, y 座標が数値ではなく変数で指定されています。
        g.color = Color.RED
        g.fillRect(x, y, 50, 50)
    }
}