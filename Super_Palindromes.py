class Solution:
    def isPalindrome(self, x: str):
        y = x
        nx = 0
        while x != 0:
            nx *= 10
            nx += x % 10
            x //= 10
        return y == nx

    def superpalindromesInRange(self, left: str, right: str) -> int:
        left, right = int(left), int(right)
        upperBound = 100000
        ans = 0
        for i in range(upperBound):
            t = str(i)
            # '12321'
            s = t + t[-2::-1]
            n = int(s)**2
            if n > right:
                break
            if n >= left and self.isPalindrome(n):
                ans += 1

        for i in range(upperBound):
            t = str(i)
            # '123321'
            s = t + t[::-1]
            n = int(s)**2
            if n > right:
                break
            if n >= left and self.isPalindrome(n):
                ans += 1
        return ans


if __name__ == '__main__':
    solution = Solution()
    testCases = [['4', '1000'], ['1', '2']]
    for testCase in testCases:
        print(solution.superpalindromesInRange(testCase[0], testCase[1]))
