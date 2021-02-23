class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        nums1 = list(map(lambda x: int(x), version1.split('.')))
        nums2 = list(map(lambda x: int(x), version2.split('.')))
        maxLen = max(len(nums1), len(nums2))
        nums1.extend(0 for i in range(len(nums1), maxLen))
        nums2.extend(0 for i in range(len(nums2), maxLen))
        # print(nums1, nums2)

        for i in range(maxLen):
            if nums1[i] < nums2[i]:
                return -1
            if nums1[i] > nums2[i]:
                return 1
        return 0


if __name__ == '__main__':
    solution = Solution()
    testCases = [['1.01', '1.001.1'], ['1.0', '1.0.0.0.0'], ['0.1', '1.1']]
    for testCase in testCases:
        print(solution.compareVersion(testCase[0], testCase[1]))
