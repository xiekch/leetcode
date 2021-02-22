// a very complex solution
function largestNumber(nums: number[]): string {
    nums = nums.sort((a, b) => {
        if (a === b) return 0
        let as: string = a.toString()
        let bs: string = b.toString()
        if (as.length === bs.length) return as < bs ? 1 : -1
        const comparator = (as: string, bs: string): number => {
            if (as === bs) return 0
            const n = as.length
            for (let i = 0; i < n; i++) {
                if (as[i] > bs[i]) return -1
                else if (as[i] < bs[i]) return 1
            }
            return bs.length - n > as.length ? comparator(as, bs.substring(n)) : (-1 * comparator(bs.substring(n), as))
        }
        return as.length < bs.length ? comparator(as, bs) : (-1 * comparator(bs, as))
    })
    let ans = nums.join('')
    while (ans[0] === '0' && ans.length > 1) ans = ans.substr(1)
    return ans
};


(_ => {
    const testCases = [[10, 2], [3, 30, 34, 33, 9], [9, 91, 92, 29, 921], [10], [0, 0]]
    for (const testCase of testCases) {
        console.log(largestNumber(testCase))
    }
})()