package jp.ac.it_college.std.nakasone.tetlin

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

/**
 * 個々のブロックを表現するクラス
 */
enum class Block {
    DUMMY, CYAN, YELLOW, GREEN, RED, BLUE, ORANGE, PURPLE;

    companion object {
        var blockImage: Bitmap? = null
    }

    private val src: Rect = Rect()

    fun width(): Int {
        return src.width()
    }

    fun height(): Int {
        return src.height()
    }

    fun render(canvas: Canvas?, dst: Rect) {
        if (src.isEmpty) {
            src.set(0,
                    blockImage!!.width * ordinal,
                    blockImage!!.width,
                    blockImage!!.width * (ordinal + 1)
            )
        }
        canvas?.drawBitmap(blockImage, src, dst, null)
    }
}