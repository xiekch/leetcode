class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet = HashSet<String>()
        wordSet.addAll(wordDict)
        val matched = BooleanArray(s.length + 1)
        matched[0] = true
        val preWords = Array<ArrayList<String>>(s.length + 1) { ArrayList() }
        for (i in 1..s.length) {
            for (j in 0 until i) {
                if (matched[j] && wordSet.contains(s.substring(j, i))) {
                    matched[i] = true
                    preWords[i].add(s.substring(j, i))
                }
            }
        }
        val res = mutableListOf<String>()
        backtrack(s.length, "", preWords, res)

        return res
    }

    private fun backtrack(
        cur: Int,
        words: String,
        preWords: Array<ArrayList<String>>,
        res: MutableList<String>
    ) {
        if (cur == 0) res.add(words)
        for (i in preWords[cur]) {
            backtrack(cur - i.length, if (words.isEmpty()) i else "$i $words", preWords, res)
        }
    }
}

fun main() {
    data class TestCase(val s: String, val wordDict: List<String>)

    val solution = Solution()
    val testCases = arrayOf(
        TestCase("catsanddog", listOf("cat", "cats", "and", "sand", "dog")),
        TestCase("pineapplepenapple", listOf("apple", "pen", "applepen", "pine", "pineapple"))
    )
    for (case in testCases) {
        println(solution.wordBreak(case.s, case.wordDict).joinToString(","))
    }
}