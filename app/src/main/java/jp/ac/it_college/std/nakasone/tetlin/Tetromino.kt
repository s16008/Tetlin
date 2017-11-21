package jp.ac.it_college.std.nakasone.tetlin

import android.graphics.Canvas
import android.graphics.Rect

/**
 * テトロミノを表現するやつ
 */
class Tetromino(val type: TetrominoType, val pos: Position = Position(5, 20), var rotate: Int = 0) {
    private val dst: Rect = Rect()
    private var prev: Int = 0

    fun render(canvas: Canvas?) {
        if (dst.isEmpty) {
            dst.set(0, 0,
                    type.block.width(),
                    type.block.height())
        }
        val db = getPositions()
        for (b in db) {
            dst.offsetTo(b.x * type.block.width(),
                    (19 - b.y) * type.block.height())
            type.block.render(canvas, dst)
        }
    }

    /**
     * FIXME: 可能なら renderと統合するように仕様変更したい
     */
    fun nextRender(canvas: Canvas?) {
        if (dst.isEmpty) {
            dst.set(0, 0,
                    type.block.width(),
                    type.block.height())
        }
        val db = getPositions()
        for (b in db) {
            dst.offsetTo(b.x * type.block.width(),
                    b.y * type.block.height())
            type.block.render(canvas, dst)
        }
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