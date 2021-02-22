// a very complex solution
function largestNumber(nums: number[]): string {
    let ans = nums.sort((a, b) => {
        let as: string = a.toString()
        let bs: string = b.toString()
        return (as + bs).localeCompare(bs + as)
    }).reverse().join('')
    while (ans[0] === '0' && ans.length > 1) ans = ans.substr(1)
    return ans
};


(_ => {
    const testCases = [[10, 2], [3, 30, 34, 33, 9], [9, 91, 92, 29, 921], [10], [0, 0]]
    for (const testCase of testCases) {
        console.log(largestNumber(testCase))
    }
})()