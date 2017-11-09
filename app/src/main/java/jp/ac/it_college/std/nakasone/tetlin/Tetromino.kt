package jp.ac.it_college.std.nakasone.tetlin

import android.graphics.Canvas
import android.graphics.Rect

/**
 * テトロミノを表現するやつ
 */
class Tetromino(val pos: Position, val type: TetrominoType, var rotate: Int = 0) {
    private val dst: Rect = Rect()

    companion object {
        fun next(): Tetromino {
            return Tetromino(Position(5, 17), TetrominoType.T)
        }
    }

    fun render(canvas: Canvas?) {
        if (dst.isEmpty) {
            dst.set(0, 0,
                    type.block.width(),
                    type.block.height())
        }
        val db = type.coords[rotate % 4]
        for (b in db) {
            dst.offsetTo((pos.x + b.x) * type.block.width(),
                    (19 - (pos.y + b.y)) * type.block.height())
            type.block.render(canvas, dst)
        }
    }

    fun moveLeft() {
        pos.x--
    }

    fun moveRight() {
        pos.x++
    }

    fun moveRotate() {
        rotate++
    }
}