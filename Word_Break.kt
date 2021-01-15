class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toHashSet()
        // dp[i] represents whether wordDict can pair to the i length of s
        val dp = BooleanArray(s.length + 1)
        dp[0] = true
        for (i in 1..s.length) {
            for (j in 0 until i) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}

class TestCase(val s: String, val wordDict: List<String>)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase("leetcode", listOf("leet", "code")), TestCase("applepenapple", listOf("apple", "pen")),
            TestCase("catsandog", listOf("cats", "dog", "sand", "and", "cat")),
            TestCase("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")))
    for (case in testCases) {
        println(solution.wordBreak(case.s, case.wordDict))
    }
}
