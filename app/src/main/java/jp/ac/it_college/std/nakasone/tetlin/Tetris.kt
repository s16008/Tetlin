package jp.ac.it_college.std.nakasone.tetlin

import android.util.Log
import android.view.View
import java.util.*
import kotlin.concurrent.timer

/**
 * テトリスのゲームクラス
 */
class Tetris(private val board: BoardView) : View.OnClickListener {
    private var dropTimer: Timer? = null
    private var isDownSkip: Boolean = false

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_left -> {
                board.currentTetromino?.moveLeft()
            }
            R.id.button_right -> {
                board.currentTetromino?.moveRight()
            }
            R.id.button_down -> {
                board.currentTetromino?.moveDown()
                isDownSkip = true
            }
            R.id.button_up -> {
                Log.i("onclick!", "うえ")
            }
            R.id.button_rotate -> {
                board.currentTetromino?.moveRotate()
            }
        }
        if (!board.checkValid()) {
            board.currentTetromino?.undo()
        }
    }

    fun startDropTimer(interval: Long) {
        cancelDropTimer()
        dropTimer = timer(initialDelay = interval, period = interval) {
            if (!isDownSkip) {
                board.currentTetromino?.moveDown()
                if (!board.checkValid()) {
                    board.currentTetromino?.undo()
                    board.storeTetromino()
                    board.deleteLines()
                    board.currentTetromino = Tetromino.next()
                }
            }
            isDownSkip = false
        }
    }

    private fun cancelDropTimer() {
        dropTimer?.cancel()
        dropTimer = null
    }

    fun debug() {
        val tet = Tetromino.next()
        board.currentTetromino = tet
    }
}