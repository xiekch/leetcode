function longestValidParentheses(s: string): number {
    let maxNum = 0
    // the longest string length in previous string
    let numStack: number[] = []
    let stack: string[] = []
    let curNum = 0
    for (const char of s) {
        if (char == '(' || stack.length == 0) {
            stack.push(char)
            if (curNum > 0) {
                numStack.push(curNum)
            }
            numStack.push(0)
            curNum = 0
        } else {
            if (stack[stack.length - 1] == '(') {
                stack.pop()
                numStack.pop()
                curNum += 2
                while (numStack[numStack.length - 1]) {
                    curNum += numStack.pop()!
                }
                maxNum = Math.max(maxNum, curNum)
            } else {
                stack.push(char)
                curNum = 0
            }
        }
    }
    return maxNum
};

let testCases = ["(())", "(())(())", "((()))())", ")(()()))", "", "))", "()(()"]
// let testCases = ["(())(())"]
for (let t of testCases)
    console.log(longestValidParentheses(t))