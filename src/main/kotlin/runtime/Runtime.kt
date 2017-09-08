package runtime

import java.awt.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.io.File
import java.util.*
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val frame = JFrame("Sample")
    frame.size = Dimension(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT)
    frame.setLocationRelativeTo(null)
    val canvas = Canvas()
    frame.add(canvas)
    frame.addKeyListener(canvas)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.isUndecorated = true
    frame.isVisible = true

}

class Canvas(
        val frameRate: Int = 60
) : JPanel(), Runnable, KeyListener {

    val game = Config.MAIN_CLASS.java.newInstance()
    val keyQueue = LinkedList<Int>()
    val keyState = HashMap<Int, Boolean>()

    init {
        Thread(this).start()
    }

    override fun run() {
        val frameTime = 1000000000L / frameRate
        while (true) {
            val begin = System.nanoTime()
            val pushedKey = keyQueue.poll() ?: KeyEvent.VK_NONCONVERT
            game.process(pushedKey)
            repaint()
            while(System.nanoTime() - begin < frameTime) {
                Thread.sleep(0, 1000)
            }
        }
    }

    override fun keyPressed(e: KeyEvent) {
        keyQueue.push(e.keyCode)
        keyState[e.keyCode] = true
        game.updateKeyState(keyState)
    }

    override fun keyReleased(e: KeyEvent) {
        keyState[e.keyCode] = false
        game.updateKeyState(keyState)
    }

    override fun keyTyped(e: KeyEvent) {

    }

    override fun paintComponent(g: Graphics) {
        g.color = Color.WHITE
        g.fillRect(0, 0, width, height)
        game.render(g)
    }
}

class ImageManager {
    companion object {
        fun load(path: String): Image {
            return ImageIO.read(File(path))
        }
    }
}