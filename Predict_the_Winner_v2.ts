// https://leetcode.com/problems/predict-the-winner/solution/
interface Array<T> {
    fill(value: T, start?: number, end?: number): this;
}

function PredictTheWinner(nums: number[]): boolean {
    let n = nums.length
    let dp = new Array(n)
    for (let i = 0; i < n; i++){
        dp[i] = new Array(n).fill(0)
        dp[i][i]=nums[i]
    }
    for (let s = nums.length; s >= 0; s--) {
        for (let e = s + 1; e < nums.length; e++) {
            let a = nums[s] - dp[s + 1][e];
            let b = nums[e] - dp[s][e - 1];
            dp[s][e] = Math.max(a, b);
        }
    }
    // console.log(dp)
    return dp[0][n - 1] >= 0
};

(function () {
    let testCases = [[1, 5, 2], [1, 5, 233, 7],
    [1, 5, 2, 4, 6]]
    for (let testCase of testCases)
        console.log(PredictTheWinner(testCase))
})()