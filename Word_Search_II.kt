// Given a 2D board and a list of words from the dictionary, find all words in the board.
//https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = buildTrie(words)
        val res = ArrayList<String>()
        for (i in board.indices) {
            for (j in board[i].indices) {
                dfs(root, board, res, i, j)
            }
        }

        return res
    }

    private fun dfs(root: TrieNode, board: Array<CharArray>, res: MutableList<String>, i: Int, j: Int) {
        val ch = board[i][j]
        if (ch == '#' || root.next[ch - 'a'] == null) return
        val p = root.next[ch - 'a']!!
        if (p.word != null) {
            p.word?.let { res.add(it) }
            p.word = null // de-duplicate
        }
        board[i][j] = '#'
        if (i > 0) dfs(p, board, res, i - 1, j)
        if (j > 0) dfs(p, board, res, i, j - 1)
        if (i < board.size - 1) dfs(p, board, res, i + 1, j)
        if (j < board[i].size - 1) dfs(p, board, res, i, j + 1)

        board[i][j] = ch
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode();
        for (word in words) {
            var p = root
            for (ch in word.toCharArray()) {
                val i = ch - 'a'
                if (p.next[i] == null) {
                    p.next[i] = TrieNode()
                }
                p = p.next[i]!!
            }
            p.word = word
        }
        return root
    }
}

class TrieNode {
    val next: Array<TrieNode?> = Array(26) { null }
    var word: String? = null
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
            arrayOf(
                    charArrayOf('o', 'a', 'a', 'n'),
                    charArrayOf('e', 't', 'a', 'e'),
                    charArrayOf('i', 'h', 'k', 'r'),
                    charArrayOf('i', 'f', 'l', 'v')
            ),
            arrayOf(
                    charArrayOf('a', 'b'),
                    charArrayOf('c', 'd')
            )
    )
    val words = arrayOf(
            arrayOf("oath", "pea", "eat", "rain"),
            arrayOf("ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb")
    )
    for (i in testset.indices) {
        val res = solution.findWords(testset[i], words[i])
        res.forEach { println(it) }
    }
}