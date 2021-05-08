/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
    for (let i = 1; i < triangle.length; i++) {
        triangle[i][0] += triangle[i - 1][0];
        triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i - 1].length - 1]
        for (let j = 1; j < triangle[i].length - 1; j++) {
            triangle[i][j] += Math.min(triangle[i - 1][j], triangle[i - 1][j - 1])
        }
    }
    return Math.min(...triangle[triangle.length - 1])
};

if (require.main === module) {
    const testCases = [[[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]], [[-10], [1, 10], [2, 3, 3]]]
    for (let testCase of testCases) {
        console.log(minimumTotal(testCase))
    }
}