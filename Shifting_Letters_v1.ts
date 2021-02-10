function shiftingLetters(S: string, shifts: number[]): string {
    let n = S.length
    let realShift = new Array<number>(n).fill(0)
    for (let i = 0; i < n; i++) {
        for (let j = 0; j <= i; j++) {
            realShift[j] += shifts[i]
        }
    }
    let ans = ''
    for (let i = 0; i < n; i++) {
        ans += String.fromCharCode('a'.charCodeAt(0) + (S[i].charCodeAt(0) - 'a'.charCodeAt(0) + realShift[i]) % 26)
    }
    return ans
};


(() => {
    let testCases = [{ S: "abc", shifts: [3, 5, 9] }]
    for (let testCase of testCases) {
        console.log(shiftingLetters(testCase.S, testCase.shifts))
    }
})()