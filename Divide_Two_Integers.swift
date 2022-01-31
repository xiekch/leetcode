// Created 2022/1/30

class Solution {
    func divide(_ _dividend: Int, _ _divisor: Int) -> Int {
        var divisor = _divisor
        var dividend = _dividend
        var res = 0
        var n = 1
        if divisor < 0 || dividend < 0 {
            if divisor > 0 || dividend > 0 {
                n = -1
            }
            dividend = abs(dividend)
            divisor = abs(divisor)
        }
        while divisor < (dividend >> 1) {
            divisor <<= 1
            n <<= 1
        }
        while divisor >= abs(_divisor), divisor != 0 {
//            print(divisor,dividend)
            while dividend >= divisor {
                dividend -= divisor
                res += n
            }
            divisor >>= 1
            n >>= 1
        }
        if res > 1 << 31 - 1 {
            return 1 << 31 - 1
        }
        if res < -(1 << 31) {
            return -(1 << 31)
        }
        return res
    }
}

func test() {
    let testCases = [(0, 1), (10, 3), (7, -3), (999, 3), (-1, -1), (-2_147_483_648, -1)]
    let solution = Solution()
    for testCase in testCases {
        print(solution.divide(testCase.0, testCase.1))
    }
}

test()
