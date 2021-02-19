function maximumGap(nums: number[]): number {
    if (nums.length < 2) return 0
    nums = nums.sort((x, y) => x - y)
    let ans = 0
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] - nums[i - 1] > ans) {
            ans = nums[i] - nums[i - 1]
        }
    }
    return ans
};


(_ => {
    const testcases = [[3, 6, 9, 1], [10], [1, 3, 100]]
    for (let testcase of testcases) {
        console.log(maximumGap(testcase))
    }
})()