import Foundation
class Solution {
    func restoreIpAddresses(_ s: String) -> [String] {
        var resStrs = [String]()
        var curStrs = [String]()
        dfs(s: s, curStrs: &curStrs, resStrs: &resStrs)
        return resStrs
    }

    func dfs(s: String, curStrs: inout [String], resStrs: inout [String]) {
        if s == "" || curStrs.count >= 4 {
            if s == "", curStrs.count == 4 {
                resStrs.append(curStrs.joined(separator: "."))
            }
            return
        }
        if s[s.startIndex] == "0" {
            curStrs.append("0")
            dfs(s: String(s[s.index(s.startIndex, offsetBy: 1) ..< s.endIndex]),
                curStrs: &curStrs, resStrs: &resStrs)
            curStrs.removeLast()
        } else {
            for i in 0 ..< s.count {
                let subStr = String(s[s.startIndex ... s.index(s.startIndex, offsetBy: i)])
                let leftStr = String(s[s.index(s.startIndex, offsetBy: i + 1) ..< s.endIndex])
                if (subStr as NSString).integerValue <= 255 {
                    curStrs.append(subStr)
                    dfs(s: leftStr, curStrs: &curStrs, resStrs: &resStrs)
                    curStrs.removeLast()
                } else {
                    break
                }
            }
        }
    }
}

let testCases: [String] = ["25525511135", "0000", "101023"]
let solution = Solution()
for testCase in testCases {
    print(solution.restoreIpAddresses(testCase))
}
