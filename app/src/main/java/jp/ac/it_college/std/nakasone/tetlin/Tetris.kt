package jp.ac.it_college.std.nakasone.tetlin

import android.util.Log
import android.view.View

/**
 * テトリスのゲームクラス
 */
class Tetris(private val board: BoardView) : View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_left -> {
                Log.i("onclick!", "ひだり")
                board.currentTetromino?.moveLeft()
            }
            R.id.button_right -> {
                Log.i("onclick!", "みぎ")
                board.currentTetromino?.moveRight()
            }
            R.id.button_down -> {
                Log.i("onclick!", "した")
            }
            R.id.button_up -> {
                Log.i("onclick!", "うえ")
            }
            R.id.button_rotate -> {
                Log.i("onclick!", "かいてん")
                board.currentTetromino?.moveRotate()
            }
        }

    }

    fun debug() {
        val tet = Tetromino.next()
        board.currentTetromino = tet
    }
}