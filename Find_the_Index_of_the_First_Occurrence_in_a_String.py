from typing import List


class Solution:
    def strStr(self, a: str, b: str) -> int:
        aLen, bLen = len(a), len(b)
        if aLen < bLen:
            return -1

        skip = self.calculateSkip(b)
        i, j = 0, 0
        while j < bLen and i < aLen:
            print(i, j, a[i], b[j])
            if a[i] == b[j]:
                j += 1
                i += 1
            else:
                j = skip[j]
                if j == -1:
                    i += 1
                    j += 1

        return i-bLen if j == bLen else -1

    def calculateSkip(self, s: str) -> List[str]:
        skip = [0 for i in range(len(s))]
        skip[0] = -1
        i = 0

        for j in range(1, len(s)):
            if i == -1:
                i = 0
            if s[j] == s[i]:
                skip[j] = skip[i]
                i += 1
            else:
                skip[j] = i
                i = skip[i]
                if s[i] == s[j]:
                    i += 1
        # print(skip)
        return skip


if __name__ == '__main__':
    solution = Solution()
    testCases = [('aab', 'aa'), ('aaab', 'aaab'),
                 ('abaabaac', 'abaac'), ("aabaaabaaac", "aabaaac")]
    for testCase in testCases:
        print(solution.strStr(testCase[0], testCase[1]))
