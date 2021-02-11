function reverseWords(s: string): string {
    return s.split(/ +/).reverse().join(' ').trim()
};


(() => {
    let testCases = ['the sky is blue', "  hello world  ", "a good   example"]
    for (let testCase of testCases) { console.log(reverseWords(testCase)) }
})()