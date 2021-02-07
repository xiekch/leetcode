// min-max algorithm
function PredictTheWinner(nums: number[]): boolean {
    return getMax(nums, 0, nums.length - 1) >= 0
};

function getMax(nums: number[], left: number, right: number): number {
    if (left == right) return nums[left]
    return Math.max(getMin(nums, left, right - 1) + nums[right], getMin(nums, left + 1, right) + nums[left])
}

function getMin(nums: number[], left: number, right: number): number {
    if (left == right) return -nums[left]
    return Math.min(getMax(nums, left, right - 1) - nums[right], getMax(nums, left + 1, right) - nums[left])
}


(function () {
    let testCases = [[1, 5, 2], [1, 5, 233, 7],
    [1, 5, 2, 4, 6]]
    for (let testCase of testCases)
        console.log(PredictTheWinner(testCase))
})()