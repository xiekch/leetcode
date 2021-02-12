function isAnagram(s: string, t: string): boolean {
    if (s.length !== t.length) return false
    let map = new Map<string, number>()
    for (let i of s) {
        if (map.has(i)) map.set(i, map.get(i) + 1)
        else map.set(i, 1)
    }
    for (let i of t) {
        if (!map.has(i) || map.get(i) <= 0) return false
        map.set(i, map.get(i) - 1)
    }
    return true
}

(() => {
    let testcases = [{ s: "anagram", t: "nagaram" }, { s: "rat", t: "car" }]
    for (let testcase of testcases) {
        console.log(isAnagram(testcase.s, testcase.t))
    }
})()