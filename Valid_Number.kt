class Solution {
    fun isNumber(s: String): Boolean {
        val arr = s.split("e", ignoreCase = true)
//        println(arr)
        if (arr.size == 1) {
            return isDecimal(arr[0]) || isInteger(arr[0])
        } else if (arr.size == 2) {
            return isDecimal(arr[0]) && isInteger(arr[1])
        }
        return false
    }

    private fun isDecimal(s: String): Boolean {
        var s = s
        if (s.isEmpty()) return false
        if (s[0] == '+' || s[0] == '-') s = s.substring(1)
        if (s.isEmpty()) return false
        val arr = s.split(".")
//        println(arr)
        if (arr.size == 1) {
            return isInteger(arr[0], false)
        } else if (arr.size == 2) {
            if (arr[0].isEmpty()) return isInteger(arr[1], false)
            if (arr[1].isEmpty()) return isInteger(arr[0], false)
            return isInteger(arr[0], false) && isInteger(arr[1], false)
        }
        return false
    }

    private fun isInteger(s: String, leadingSign: Boolean = true): Boolean {
        var s = s
        if (s.isEmpty()) return false
        if (leadingSign && (s[0] == '+' || s[0] == '-')) s = s.substring(1)
//        println(s)
        return s.matches(Regex("\\d+"))
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        "2",
        "0089",
        "-0.1",
        "+3.14",
        "4.",
        "-.9",
        "2e10",
        "-90E3",
        "3e+7",
        "+6e-1",
        "53.5e93",
        "-123.456e789",
        "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53",
        ".-4"
    )
    for (testCase in testCases) {
        println(solution.isNumber(testCase))
    }
}