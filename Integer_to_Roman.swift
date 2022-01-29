class Solution {
    let romanMap = [(1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"), (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"), (5, "V"), (4, "IV"), (1, "I")]
    func intToRoman(_ num: Int) -> String {
        var num = num
        var res = ""
        for i in romanMap {
            while num >= i.0 {
                res += i.1
                num -= i.0
            }
        }
        return res
    }
}

func test() {
    let testCases = [1, 2, 8, 14, 115, 644, 999, 3999]
    let solution = Solution()
    for testCase in testCases {
        print(solution.intToRoman(testCase))
    }
}

test()
