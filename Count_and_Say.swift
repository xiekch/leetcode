class Solution {
    func countAndSay(_ n: Int) -> String {
        if n == 1 {
            return "1"
        }
        let last = Array(countAndSay(n - 1))
        var res = ""
        var count = 1
        for i in 1 ..< last.count {
            if last[i] == last[i - 1] {
                count += 1
            } else {
                res += "\(count)\(last[i - 1])"
                count = 1
            }
        }
        res += "\(count)\(last[last.count - 1])"
        return res
    }
}

func test() {
    let testCases = [1, 2, 3, 4, 5, 6, 7]
    let solution = Solution()
    for testCase in testCases {
        print(solution.countAndSay(testCase))
    }
}

test()
