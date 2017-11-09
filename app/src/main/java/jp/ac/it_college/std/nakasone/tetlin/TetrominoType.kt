package jp.ac.it_college.std.nakasone.tetlin

/**
 * テトロミノの種類を定義する列挙クラス
 */
enum class TetrominoType(val block: Block, val coords: Array<Array<Position>>) {
    I(Block.CYAN, arrayOf(
            arrayOf(Position(-2, 0), Position(-1, 0), Position(0, 0), Position(1, 0)),
            arrayOf(Position(0, -1), Position(0, 0), Position(0, 1), Position(0, 2)),
            arrayOf(Position(-1, 0), Position(0, 0), Position(1, 0), Position(2, 0)),
            arrayOf(Position(0, -2), Position(0, -1), Position(0, 0), Position(0, 1))
    )),
    O(Block.YELLOW, arrayOf(
            arrayOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 0)),
            arrayOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 0)),
            arrayOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 0)),
            arrayOf(Position(0, 0), Position(0, 1), Position(1, 1), Position(1, 0))
    )),
    S(Block.GREEN, arrayOf(
            arrayOf(Position(-1, 0), Position(0, 0), Position(0, 1), Position(1, 1)),
            arrayOf(Position(0, 1), Position(0, 0), Position(1, 0), Position(1, -1)),
            arrayOf(Position(1, 0), Position(0, 0), Position(0, -1), Position(-1, -1)),
            arrayOf(Position(0, -1), Position(0, 0), Position(-1, 0), Position(-1, 1))
    )),
    Z(Block.RED, arrayOf(
            arrayOf(Position(-1, 1), Position(0, 1), Position(0, 0), Position(1, 0)),
            arrayOf(Position(1, 1), Position(1, 0), Position(0, 0), Position(0, -1)),
            arrayOf(Position(1, -1), Position(0, -1), Position(0, 0), Position(-1, 0)),
            arrayOf(Position(-1, -1), Position(-1, 0), Position(0, 0), Position(0, 1))
    )),
    J(Block.BLUE, arrayOf(
            arrayOf(Position(-1, 1), Position(-1, 0), Position(0, 0), Position(1, 0)),
            arrayOf(Position(1, 1), Position(0, 1), Position(0, 0), Position(0, -1)),
            arrayOf(Position(-1, 1), Position(1, 0), Position(0, 0), Position(-1, 0)),
            arrayOf(Position(-1, -1), Position(0, -1), Position(0, 0), Position(0, 1))
    )),
    L(Block.ORANGE, arrayOf(
            arrayOf(Position(-1, 0), Position(0, 0), Position(1, 0), Position(1, 1)),
            arrayOf(Position(0, 1), Position(0, 0), Position(0, -1), Position(1, -1)),
            arrayOf(Position(1, 0), Position(0, 0), Position(-1, 0), Position(-1, -1)),
            arrayOf(Position(0, -1), Position(0, 0), Position(0, 1), Position(-1, 1))
    )),
    T(Block.PURPLE, arrayOf(
            arrayOf(Position(-1, 0), Position(0, 1), Position(1, 0), Position(0, 0)),
            arrayOf(Position(0, 1), Position(1, 0), Position(0, -1), Position(0, 0)),
            arrayOf(Position(1, 0), Position(0, -1), Position(-1, 0), Position(0, 0)),
            arrayOf(Position(0, -1), Position(-1, 0), Position(0, 1), Position(0, 0))
    )),
}