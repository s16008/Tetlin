package jp.ac.it_college.std.nakasone.tetlin

import android.graphics.Canvas
import android.graphics.Rect
import android.util.Log

/**
 * テトロミノを表現するやつ
 */
class Tetromino(
        val type: TetrominoType,
        private val pos: Position = Position(4, 20),
        private var rotate: Int = 0) {

    private val dst: Rect = Rect()
    private var prev: Int = 0

    fun render(canvas: Canvas?, translate: Boolean = true) {
        if (dst.isEmpty) {
            dst.set(0, 0,
                    type.block.width(),
                    type.block.height())
        }

        canvas?.save()

        if (translate) {
            canvas?.translate(pos.x.toFloat() * type.block.width(),
                    (20 - pos.y - 1).toFloat() * type.block.height())
        }

        for (b in type.coords[rotate % 4]) {
            dst.offsetTo(b.x * type.block.width(),
                    -b.y * type.block.height())
            type.block.render(canvas, dst)
        }

        canvas?.restore()
    }

    fun moveLeft() {
        pos.x--
        prev = 1
    }

    fun moveRight() {
        pos.x++
        prev = 2
    }

    fun moveRotate() {
        rotate++
        prev = 3
    }

    fun moveDown() {
        pos.y--
        prev = 4
    }

    fun moveUp() {
        pos.y++
    }

    fun undo() {
        when (prev) {
            1 -> {
                pos.x++
            }
            2 -> {
                pos.x--
            }
            3 -> {
                rotate--
            }
            4 -> {
                pos.y++
            }
        }
    }

    fun getPositions(): Array<Position> {
        val target = type.coords[rotate % 4]
        return arrayOf(pos + target[0],
                pos + target[1],
                pos + target[2],
                pos + target[3])
    }
}