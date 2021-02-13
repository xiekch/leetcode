function numberOfSteps(num: number): number {
    let ans = 0
    while (num !== 0) {
        // if ((num & 1) == 0) num >>=1
        if (num % 2 === 0) num /= 2
        else num -= 1
        ans++
    }
    return ans
};


(() => {
    const testcases = [14, 8, 123]
    for (let testcase of testcases) {
        console.log(numberOfSteps(testcase))
    }
})()