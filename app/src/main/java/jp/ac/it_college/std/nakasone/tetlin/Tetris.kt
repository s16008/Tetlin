package jp.ac.it_college.std.nakasone.tetlin

import android.util.Log
import android.view.View
import java.util.*
import kotlin.concurrent.timer

/**
 * テトリスのゲームクラス
 */
class Tetris(private val board: BoardView, private val next: NextView) : View.OnClickListener {
    private var dropTimer: Timer? = null
    private var isDownSkip: Boolean = false
    private val tetrominoQueue = mutableListOf<Tetromino>()
    private val rand = Sfmt((System.currentTimeMillis() % Int.MAX_VALUE).toInt())

    init {
        next.blockSize = Block.blockImage?.width ?: 0
        next.queue = tetrominoQueue
    }

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
                    board.currentTetromino = nextTetromino()
                }
            }
            isDownSkip = false
        }
    }

    private fun cancelDropTimer() {
        dropTimer?.cancel()
        dropTimer = null
    }

    private fun nextTetromino(): Tetromino {
        if (tetrominoQueue.size < 4) {
            generateTetromino()
        }
        val nextTetromino = tetrominoQueue.removeAt(0)
        next.invalidate()
        return nextTetromino
    }

    private fun generateTetromino() {
        val base = mutableListOf<Tetromino>(
                Tetromino(TetrominoType.I),
                Tetromino(TetrominoType.I),
                Tetromino(TetrominoType.O),
                Tetromino(TetrominoType.O),
                Tetromino(TetrominoType.S),
                Tetromino(TetrominoType.S),
                Tetromino(TetrominoType.Z),
                Tetromino(TetrominoType.Z),
                Tetromino(TetrominoType.J),
                Tetromino(TetrominoType.J),
                Tetromino(TetrominoType.L),
                Tetromino(TetrominoType.L),
                Tetromino(TetrominoType.T),
                Tetromino(TetrominoType.T)
        )
        for (s in 0..8) {
            for (a in 0..13) {
                val t = rand.NextInt(base.size)
                val tmp = base[a]
                base[a] = base[t]
                base[t] = tmp
            }
        }
        tetrominoQueue.addAll(base)
    }

    fun debug() {
        board.currentTetromino = nextTetromino()
    }
}