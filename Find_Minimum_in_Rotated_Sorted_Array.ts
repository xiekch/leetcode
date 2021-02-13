function findMin(nums: number[]): number {
    const n = nums.length - 1
    if (nums[0] < nums[n]) return nums[0]
    let right = n, left = 0
    while (right > left) {
        let mid = Math.floor((right + left) / 2)
        if (nums[mid] < nums[n]) right = mid
        else left = mid + 1
    }
    return nums[right]
};


(() => {
    const testcases = [[3, 4, 5, 1, 2], [4, 5, 6, 7, 0, 1, 2], [11, 13, 15, 17]]
    for (let testcase of testcases) {
        console.log(findMin(testcase))
    }
})()