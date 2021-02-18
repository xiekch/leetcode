function findRepeatedDnaSequences(s: string): string[] {
    const map = new Map<string, number>()
    const ans: string[] = []
    for (let i = 0; i + 10 <= s.length; i++) {
        const sub = s.substring(i, i + 10)
        const count = (map.has(sub) ? map.get(sub) : 0) + 1
        map.set(sub, count)
        if (count === 2) ans.push(sub)
    }
    return ans
};

(_ => {
    const testcases = ["AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", "AAAAAAAAAAAAA", "AAAAAAAAAAA"]
    for (let testcase of testcases) {
        console.log(findRepeatedDnaSequences(testcase))
    }
})()