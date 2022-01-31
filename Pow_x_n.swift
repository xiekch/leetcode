// Created 2022/1/31

class Solution {
    func myPow(_ _x: Double, _ _n: Int) -> Double {
        var result = 1.0
        var x: Double
        var n: Int
        if _n < 0 {
            x = 1 / _x
            n = -_n
        } else {
            x = _x
            n = _n
        }
        while n != 0 {
            if n % 2 != 0 {
                result *= x
            }
            x *= x
            n >>= 1
        }
        return result
    }
}

func test() {
    let testCases = [(0, 1), (0, 0), (2, 0), (10.0, 3), (7.0, -3),
                     (999.0, 3), (-1.0, -1), (2.0, -2), (2.0, 10)]
    let solution = Solution()
    for testCase in testCases {
        print(solution.myPow(testCase.0, testCase.1))
    }
}

test()
