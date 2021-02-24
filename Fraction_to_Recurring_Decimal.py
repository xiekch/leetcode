class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator == 0:
            return '0'
        ans = ''
        if numerator*denominator < 0:
            ans = '-'
            numerator = abs(numerator)
            denominator = abs(denominator)
        ans += str(numerator//denominator)
        numerator %= denominator
        if numerator == 0:
            return ans
        ans += '.'

        m = {numerator: len(ans)}
        while numerator != 0:
            numerator *= 10
            ans += str(numerator//denominator)
            numerator = numerator % denominator
            if numerator in m:
                ans = ans[:m[numerator]]+'('+ans[m[numerator]:] + ')'
                break
            m[numerator] = len(ans)

        return ans


if __name__ == '__main__':
    solution = Solution()
    testCases = [[1, 5], [2, 1], [1, 3],  [4, 333], [1, 6], [-5, 2], [-1, 11]]
    for testCase in testCases:
        print(solution.fractionToDecimal(testCase[0], testCase[1]))
