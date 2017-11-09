package jp.ac.it_college.std.nakasone.tetlin

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout

class MainActivity : Activity() {
    private var tetris: Tetris? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blockMap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.blocks)
        Block.blockImage = blockMap

        val container: FrameLayout = findViewById(R.id.borad)
        val board = BoardView(this, blockMap.width)
        tetris = Tetris(board)
        container.addView(board)

        findViewById<View>(R.id.button_left).setOnClickListener(tetris)
        findViewById<View>(R.id.button_right).setOnClickListener(tetris)
        findViewById<View>(R.id.button_down).setOnClickListener(tetris)
        findViewById<View>(R.id.button_up).setOnClickListener(tetris)
        findViewById<View>(R.id.button_rotate).setOnClickListener(tetris)

        tetris?.debug()
    }
}
