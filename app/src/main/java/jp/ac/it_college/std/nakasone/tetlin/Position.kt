package jp.ac.it_college.std.nakasone.tetlin

/**
 * ボード上の座標を表現
 */
class Position(var x: Int, var y: Int) {
    operator fun plus(b:Position):Position = Position(this.x + b.x, this.y + b.y)
}