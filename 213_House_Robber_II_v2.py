from typing import List
# All houses at this place are arranged in a circle.
# Meanwhile, adjacent houses have security system connected and it will
#  automatically contact the police if two adjacent houses were broken into on the same night.
# https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation


class Solution:
    def robSub(self, nums: List[int], start: int, end: int) -> int:
        exclude, include, e, i = 0, 0, 0, 0
        for i in range(start, end):
            exc, inc = exclude, include
            include = exc+nums[i]
            exclude = max(exc, inc)
        return max(exclude, include)

    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        return max(nums[0]+self.robSub(nums, 2, len(nums)-1), self.robSub(nums, 1, len(nums)))


if __name__ == '__main__':
    sol = Solution()
    testset = [[2, 3, 2], [1, 2, 3, 1], [2, 4, 4, 5, 10, 7, 2, 3, 4, 5]]
    for nums in testset:
        print(sol.rob(nums))
