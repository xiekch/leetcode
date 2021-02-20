function findPeakElement(nums: number[]): number {
    const n = nums.length
    if (n === 1 || nums[0] > nums[1]) return 0
    if (nums[n - 1] > nums[n - 2]) return n - 1
    for (let i = 1; i < n - 1; i++) {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i
    }
};

(_ => {
    const testCases = [[1, 2, 3, 1], [1, 2, 1, 3, 5, 6, 4], [1], [1, 2]]
    for (const testCase of testCases) {
        console.log(findPeakElement(testCase))
    }
})()