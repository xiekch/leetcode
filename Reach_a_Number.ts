// During the n-th move (starting from 1), you take n steps.

function reachNumber(target: number): number {
    if (target < 0) target = -target
    let sum = 0
    for (let i = 1; ; i++) {
        sum += i
        if (sum >= target && (sum - target) % 2 == 0)
            return i
    }
};

(() => {
    const testcases = [3, 2, -3, 123456789]
    for (let testcase of testcases) {
        console.log(reachNumber(testcase))
    }
})()