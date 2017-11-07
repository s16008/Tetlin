package jp.ac.it_college.std.nakasone.tetlin

import android.view.View

/**
 * テトリスのゲームクラス
 */
class Tetris(private val board: BoardView) : View.OnClickListener {


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_left -> {
            }
            R.id.button_right -> {
            }
            R.id.button_down -> {
            }
            R.id.button_up -> {
            }
            R.id.button_rotate -> {
            }
        }

    }

}