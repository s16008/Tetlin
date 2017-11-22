package jp.ac.it_college.std.nakasone.tetlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/**
 * Nextの表示するやつ
 */
class NextView @JvmOverloads constructor(
        context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0, defStyleRes: Int = 0)
    : View(context, attrs, defStyleAttr, defStyleRes) {

    var queue: MutableList<Tetromino> = mutableListOf()

    var blockSize: Int = 0
        set(value) {
            field = value * 2 / 3
        }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = 4 * blockSize
        val height = 9 * blockSize
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawColor(Color.DKGRAY)

        if (queue.size < 3) {
            return
        }
        for (i in 0..2) {
            val tetromino = queue[i]
            canvas?.save()

            canvas?.translate((blockSize * 1).toFloat(),
                    (blockSize + i * 3 * blockSize).toFloat())

            canvas?.scale(2f / 3f, 2f / 3f)
            tetromino.render(canvas, false)

            canvas?.restore()
        }

//        canvas?.drawBitmap()
    }
}