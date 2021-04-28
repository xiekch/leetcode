function searchMatrix(matrix: number[][], target: number): boolean {
    let i = 0, j = 0
    while (i + 1 < matrix.length) {
        if (matrix[i + 1][0] <= target) i++
        else break
    }
    while (j < matrix[i].length) {
        if (matrix[i][j] === target) return true;
        if (matrix[i][j] < target) j++;
        else break;
    }
    return false
};

(() => {
    let testCases = [{ matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target: 3 },
    { matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target: 13 },
    { matrix: [[1], [3]], target: 3 }]
    for (let testCase of testCases) {
        console.log(searchMatrix(testCase.matrix, testCase.target))
    }
})()