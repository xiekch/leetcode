from typing import List


class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        return self.eval(expression)

    def eval(self, expression: str) -> List[int]:
        res = list()
        start, end = 0, len(expression)
        for i in range(0, end):
            if self.isOperator(expression[i]):
                left = self.eval(expression[start:i])
                right = self.eval(expression[i+1:end])
                for l in left:
                    for r in right:
                        # print(l,  expression[i], r)
                        res.append(self.calculate(l, r, expression[i]))
        if len(res) == 0:
            res.append(int(expression[start:end]))

        return res

    def isOperator(self, e):
        return e in ['+', '-', '*']

    def calculate(self, a: int, b: int, operator: str) -> int:
        if operator == '+':
            return a + b
        elif operator == '-':
            return a - b
        elif operator == '*':
            return a * b
        else:
            return 0


if __name__ == '__main__':
    testCases = ["2", "2*3-4", "2-1-1", "2*3-4*5"]
    for testCase in testCases:
        print(Solution().diffWaysToCompute(testCase))
