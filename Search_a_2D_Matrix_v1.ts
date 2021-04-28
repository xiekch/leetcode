function searchMatrix(matrix: number[][], target: number): boolean {
    const row = matrix.length, col = matrix[0].length
    let left = 0, right = row * col - 1
    while (left <= right) {
        const mid = Math.floor((left + right) / 2)
        const ele = matrix[Math.floor(mid / col)][mid % col]
        if (ele === target) return true
        else if (ele < target) left = mid + 1
        else right = mid - 1
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