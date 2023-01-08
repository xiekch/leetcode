from typing import List


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        combinations = []
        combination = []
        self.combine(k, n, combination, combinations)
        return combinations

    def combine(self, k: int, n: int, combination: List[int], combinations: List[List[int]]):
        partSum = sum(combination)
        # print(k, n, combination, partSum)
        if k <= 0:
            if partSum == n:
                # print(combination)
                combinations.append(combination.copy())
            return

        if len(combination) > 0:
            lowerBound = combination[len(combination)-1] + 1
        else:
            lowerBound = 1

        # optimization: when k == 1, compute directly
        if k == 1:
            if n - partSum >= lowerBound and n - partSum < 10:
                res = combination.copy()
                res.append(n - partSum)
                combinations.append(res)
            return
        # optimization: lower bound & upper bound for i
        for i in range(lowerBound,  10-(k-1)):
            # optimization: compute lower bound to cut off branches
            if i * k + k-1 + partSum <= n:
                combination.append(i)
                self.combine(k-1, n, combination, combinations)
                combination.pop()
            else:
                break


if __name__ == '__main__':
    testCases = [[3, 7], [3, 9], [4, 1], [5, 30]]
    solution = Solution()
    for testCase in testCases:
        print(solution.combinationSum3(testCase[0], testCase[1]))
