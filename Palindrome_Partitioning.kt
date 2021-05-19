class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()

        combine(s, mutableListOf(), res)
        return res
    }

    private fun combine(s: String, path: MutableList<String>, res: MutableList<List<String>>) {
        if (s.isEmpty()) {
            res.add(path.toList())
            return
        }
        path.add(s[0].toString())
        combine(s.substring(1), path, res)
        path.removeAt(path.lastIndex)

        for (i in 2..s.length) {
            if (isPalindrome(s.substring(0, i))) {
                path.add(s.substring(0, i))
                combine(s.substring(i), path, res)
                path.removeAt(path.lastIndex)
            }
        }
    }

    private fun isPalindrome(s: String): Boolean {
        val n = s.length
        for (i in 0 until n / 2) {
            if (s[i] != s[n - 1 - i]) return false
        }
        return true
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        "aab",
        "a",
        "aaa"
    )

    val res = mutableListOf<List<String>>()
    val a = mutableListOf("a", "b")
    res.add(a)
    a.removeAt(0)
    println(a)
    println(res)

    for (testCase in testCases) {
        println(solution.partition(testCase).joinToString("\n"))
        println()
    }
}
