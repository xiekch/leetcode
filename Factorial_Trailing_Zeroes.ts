// https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52373/Simple-CC%2B%2B-Solution-(with-detailed-explaination)
function trailingZeroes(n: number): number {
    let sum = 0
    for (let i = 5; i <= n; i *= 5) {
        sum += Math.floor(n / i);
    }
    return sum
};

console.log(trailingZeroes(30))
console.log(trailingZeroes(1))
console.log(trailingZeroes(0))