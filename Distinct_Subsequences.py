# https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
from typing import List


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        sl = len(s)
        tl = len(t)
        dp: List[List[int]] = [[0 for i in range(tl+1)]for i in range(sl+1)]
        for i in range(0, sl+1):
            dp[i][0] = 1
        for i in range(1, sl+1):
            for j in range(1, tl+1):
                dp[i][j] = dp[i-1][j]
                if s[i-1] == t[j-1]:
                    dp[i][j] += dp[i-1][j-1]
        return dp[sl][tl]


if __name__ == '__main__':
    solution = Solution()
    testCases = [{'s': 'rabbbit', 't': 'rabbit'}]
    for testCase in testCases:
        print(solution.numDistinct(testCase['s'], testCase['t']))
