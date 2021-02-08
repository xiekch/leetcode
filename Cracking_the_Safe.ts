function crackSafe(n: number, k: number): string {
    let start = ''
    for (let i = 0; i < n; i++) {
        start += '0'
    }
    let ans = start
    let visited = new Set<string>()
    visited.add(start)
    let pre = start
    while (visited.size < Math.pow(k,n)) {
        //  visit in post-order to prevent getting suck
        for (let j = k - 1; j >= 0; j--) {
            let neighbor = pre.substr(1) + String(j)
            if (!visited.has(neighbor)) {
                visited.add(neighbor)
                ans += String(j)
                pre = neighbor
                break;
            }
        }
    }
    return ans
};


(function () {
    let testCases = [{ n: 1, k: 2 }, { n: 2, k: 2 }]
    for (let testCase of testCases) {
        console.log(crackSafe(testCase.n, testCase.k))
    }
})()

