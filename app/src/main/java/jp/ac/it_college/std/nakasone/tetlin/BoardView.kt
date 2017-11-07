package jp.ac.it_college.std.nakasone.tetlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.*
import kotlin.concurrent.timer

/**
 * テトリスの盤面を描画するビュー
 */
class BoardView(context: Context?, private val blockSize: Int) : SurfaceView(context), SurfaceHolder.Callback {
    private var drawTimer: Timer? = null
    private val blockList = Array(10, { Array<Block?>(23, { null }) })
    private val dstRect = Rect(0, 0, blockSize, blockSize)

    init {
        holder.addCallback(this)
        blockList[0][0] = Block.CYAN
        blockList[1][1] = Block.YELLOW
        blockList[2][2] = Block.GREEN
        blockList[3][3] = Block.RED
        blockList[4][4] = Block.BLUE
        blockList[5][5] = Block.ORANGE
        blockList[6][6] = Block.PURPLE
    }

    companion object {
        const val CELL_WIDTH: Int = 10
        const val CELL_HEIGHT: Int = 20
        const val DRAW_INTERVAL: Long = 1000 / 60
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = blockSize * CELL_WIDTH
        val height = blockSize * CELL_HEIGHT

        setMeasuredDimension(width, height)
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        cancelTimer()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        startTimer()
    }

    private fun render() {
        if (holder.isCreating) {
            return
        }

        val canvas: Canvas? = holder.surface.lockHardwareCanvas()

        canvas?.drawColor(Color.WHITE)
        for (x in 0..9) {
            for (y in 0..19) {
                dstRect.offsetTo(x * blockSize, y * blockSize)
                blockList[x][y]?.render(canvas, dstRect)
            }
        }
        holder.surface.unlockCanvasAndPost(canvas)
    }

    private fun startTimer() {
        cancelTimer()
        drawTimer = timer(initialDelay = DRAW_INTERVAL, period = DRAW_INTERVAL) {
            render()
        }
    }

    private fun cancelTimer() {
        drawTimer?.cancel()
        drawTimer = null
    }
}