
class Solution {
    private var found = false
    fun solveSudoku(board: Array<CharArray>) {
        found = false
        val rows = Array(9) { BooleanArray(10) { it == 0 } }
        val columns = Array(9) { BooleanArray(10) { it == 0 } }
        val boxes = Array(9) { BooleanArray(10) { it == 0 } }
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] != '.') {
                    val k = Integer.parseInt(board[i][j].toString())
                    rows[i][k] = true
                    columns[j][k] = true
                    boxes[(i / 3) * 3 + j / 3][k] = true
                }
            }
        }
        solveSudoku(board, rows, columns, boxes, 0, 0)

//        println(found)
    }


    private fun solveSudoku(
        board: Array<CharArray>,
        rows: Array<BooleanArray>,
        columns: Array<BooleanArray>,
        boxes: Array<BooleanArray>,
        curRow: Int,
        curColumn: Int
    ) {
        if (found) return
        if (curRow == 9) {
            if (rows.all { row -> row.all { it } } && columns.all { col -> col.all { it } }
                && boxes.all { box -> box.all { it } }) {
                found = true
            }
            return
        }

        for (j in curColumn..8) {
            if (board[curRow][j] == '.') {
                for (k in 1..9) {
                    if (!rows[curRow][k] && !columns[j][k] && !boxes[(curRow / 3) * 3 + j / 3][k] && !found) {
                        board[curRow][j] = (k + '0'.toInt()).toChar()
                        rows[curRow][k] = true
                        columns[j][k] = true
                        boxes[(curRow / 3) * 3 + j / 3][k] = true
                        if (j == 8)
                            solveSudoku(board, rows, columns, boxes, curRow + 1, 0)
                        else solveSudoku(board, rows, columns, boxes, curRow, j + 1)
                        if (found) return
                        board[curRow][j] = '.'
                        rows[curRow][k] = false
                        columns[j][k] = false
                        boxes[(curRow / 3) * 3 + j / 3][k] = false
                    }
                }
                return
            } else if (j == 8 && rows[curRow].all { it }) {
                solveSudoku(board, rows, columns, boxes, curRow + 1, 0)
            }
        }
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        arrayOf(
            charArrayOf('5', '3', '4', '6', '7', '8', '9', '.', '2'),
            charArrayOf('6', '7', '2', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '9', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '6', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('3', '4', '.', '.', '8', '.', '.', '7', '9')
        ),
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )
    for (testCase in testCases) {
        solution.solveSudoku(testCase)
        println(testCase.joinToString("\n") { it.joinToString() })
        println()
    }
}
