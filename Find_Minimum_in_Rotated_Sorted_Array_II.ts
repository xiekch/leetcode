function findMin(nums: number[]): number {
    return Math.min(...nums)
};


(() => {
    const testcases = [[3, 4, 5, 1, 2], [4, 5, 6, 7, 0, 1, 2], [11, 13, 15, 17],
    [2, 2, 2, 4, 5, 0, 1, 2], [10, 1, 10, 10, 10], [3, 3, 1, 3], [3, 3, 1, 2, 2, 2, 2, 2, 2, 3],
    [3, 3, 3, 3, 3, 3, 3, 1, 2, 2]]
    for (let testcase of testcases) {
        console.log(findMin(testcase))
    }
})()