/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function (triangle) {
    for (let i = triangle.length - 2; i >= 0; i--) {
        for (let j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.min(triangle[i + 1][j], triangle[i + 1][j + 1])
        }
    }
    return triangle[0][0]
};

if (require.main === module) {
    const testCases = [[[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]], [[-10], [1, 10], [2, 3, 3]]]
    for (let testCase of testCases) {
        console.log(minimumTotal(testCase))
    }
}