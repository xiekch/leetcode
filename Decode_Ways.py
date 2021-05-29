class Solution:
    def numDecodings(self, s: str) -> int:
        if len(s) == 0:
            return 0
        dp = [0] * (len(s)+1)
        if s[0] == '0':
            return 0
        dp[0] = dp[1] = 1
        for i in range(1, len(s)):
            if not self.isValid(s[i]):
                if not self.isValid(s[i-1: i+1]):
                    return 0
                else:
                    dp[i+1] = dp[i-1]
            else:
                dp[i+1] = dp[i]
                if self.isValid(s[i-1: i+1]):
                    dp[i+1] += dp[i-1]
        return dp[len(s)]

    def isValid(self, s: str) -> bool:
        if s[0] == '0':
            return False
        if int(s) >= 1 and int(s) <= 26:
            return True
        return False


if __name__ == '__main__':
    solution = Solution()
    testCases = ["12", "226", '0', '06', "121321721712010123", '3055']
    for testCase in testCases:
        print(solution.numDecodings(testCase))
