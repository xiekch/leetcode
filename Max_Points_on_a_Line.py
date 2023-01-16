import math
from typing import List
from collections import defaultdict


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if len(points) == 0:
            return 0
        maxPointsInALine = 1
        for i in range(0, len(points)):
            cnt = defaultdict(int)
            for j in range(0, len(points)):
                if i != j:
                    theta = math.atan2(
                        points[j][1]-points[i][1], points[j][0]-points[i][0])
                    cnt[theta] += 1
                    maxPointsInALine = max(
                        maxPointsInALine, max(cnt.values())+1)

        return maxPointsInALine


if __name__ == '__main__':
    testCases = [[[1, 1], [2, 2], [3, 3]],
                 [[1, 1], [3, 2], [5, 3], [4, 1], [2, 3], [1, 4]],
                 [[0, 0]]]
    for testCase in testCases:
        print(Solution().maxPoints(testCase))
