function shortestPathBinaryMatrix(grid: number[][]): number {
    // bfs
    const n = grid.length
    if (grid[0][0] === 1 || grid[n - 1][n - 1]) return -1
    const visited: boolean[][] = Array(n).fill(null).map(_ => Array(n).fill(false))
    const qu: { x: number, y: number, step: number }[] = [{ x: 0, y: 0, step: 1 }]
    visited[0][0] = true
    const delta = [[1, 0], [1, 1], [1, -1], [0, 1], [0, -1], [-1, 1], [-1, 0], [-1, -1]]
    while (qu.length) {
        const node = qu.shift()
        if (node.x === n - 1 && node.y === n - 1) return node.step
        delta.forEach(([dx, dy]) => {
            const nx = node.x + dx, ny = node.y + dy
            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && grid[nx][ny] === 0) {
                qu.push({ x: nx, y: ny, step: node.step + 1 })
                visited[nx][ny] = true
            }
        })
    }
    return -1
};


(() => {
    // 2 4 -1 10
    const testCases = [[[0, 1], [1, 0]], [[0, 0, 0], [1, 1, 0], [1, 1, 0]], [[1, 0, 0], [1, 1, 0], [1, 1, 0]],
    [[0, 0, 1, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0, 1], [0, 0, 1, 0, 1, 0, 0], [0, 0, 0, 1, 1, 1, 0], [1, 0, 0, 1, 1, 0, 0], [1, 1, 1, 1, 1, 0, 1], [0, 0, 1, 0, 0, 0, 0]]]
    for (let testCase of testCases) {
        console.log(shortestPathBinaryMatrix(testCase))
    }
})()