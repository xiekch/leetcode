/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function (matrix) {
    if (matrix.length == 0) return 0;
    let n = matrix.length;
    let m = matrix[0].length;
    let height = new Array(m).fill(0)
    let left = new Array(m).fill(0)
    let right = new Array(m).fill(m)
    let ans = 0;
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (matrix[i][j] == '1') height[j] += 1;
            else height[j] = 0
        }
        let leftMost = 0;
        for (let j = 0; j < m; j++) {
            if (matrix[i][j] == '1') left[j] = Math.max(left[j], leftMost);
            else {
                left[j] = 0
                leftMost = j + 1
            }
        }
        let rightMost = m;
        for (let j = m - 1; j >= 0; j--) {
            if (matrix[i][j] == '1') right[j] = Math.min(right[j], rightMost);
            else {
                right[j] = m
                rightMost = j
            }
            ans = Math.max(ans, height[j] * (right[j] - left[j]))
        }
        // console.log(height, right, left)
    }
    return ans;
};

let testcase = [["1", "0", "1", "0", "0"],
["1", "0", "1", "1", "1"],
["1", "1", "1", "1", "1"],
["1", "0", "0", "1", "0"]]
console.log(maximalRectangle(testcase))