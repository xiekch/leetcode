class Solution {
    fun validIPAddress(IP: String): String {
        val ipv4Chunk = "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])"
        val ipv4Pattern = Regex("($ipv4Chunk\\.){3}$ipv4Chunk")
        val ipv6Chunk = "([0-9a-fA-F]{1,4})"
        val ipv6Pattern = Regex("($ipv6Chunk:){7}$ipv6Chunk")
        return if (ipv4Pattern.matches(IP)) "IPv4" else if (ipv6Pattern.matches(IP)) "IPv6" else "Neither"
    }
}


fun main() {
    val solution = Solution()
    println(solution.validIPAddress("193"))
    println(solution.validIPAddress("0.0.0.0"))
    println(solution.validIPAddress("192.168.1.0"))
    println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
}