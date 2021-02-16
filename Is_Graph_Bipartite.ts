function isBipartite(graph: number[][]): boolean {
    const n = graph.length
    const mark: number[] = Array(n).fill(-1)
    // bfs
    for (let i = 0; i < n; i++) {
        if (mark[i] !== -1) continue
        let qu: number[] = graph[i].concat()
        let lastMark = mark[i] = 0
        while (qu.length) {
            // console.log(qu)
            const length = qu.length
            for (let j = 0; j < length; j++) {
                const node = qu.shift()
                if (mark[node] === lastMark) {
                    return false
                }
                if (mark[node] !== -1) continue
                mark[node] = 1 - lastMark
                qu = qu.concat(graph[node])
            }
            lastMark = 1 - lastMark
        }
    }
    return true
};


(() => {
    const testCases = [[[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]], [[1, 3], [0, 2], [1, 3], [0, 2], []],
    [[3], [2, 4], [1], [0, 4], [1, 3]]]
    for (const testCase of testCases) {
        console.log(isBipartite(testCase))
    }
})()