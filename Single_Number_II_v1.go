package main

// int is a signed integer type that is at least 32 bits in size.
// It is a distinct type, however, and not an alias for, say, int32.
// The int, uint, and uintptr types are usually 32 bits wide on 32-bit systems and 64 bits wide on 64-bit systems.
func singleNumber(nums []int) int {
	var ans int32 = 0
	for i := 0; i < 32; i++ {
		var bitSum uint32 = 0
		for _, n := range nums {
			// first n>>i, be careful of overflow
			bitSum += uint32(n>>i) & 1
		}
		// every element appears three times except for one
		bitSum %= 3
		ans += int32(bitSum) << i
		// println(ans, bitSum<<i)
	}
	return int(ans)
}

func main() {
	var testCases = [][]int{
		{2, 2, 3, 2},
		{0, 1, 0, 1, 0, 1, 99},
		{-1, -1, -1, -2},
		{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2},
		{2, 2, 2, -1, -1, -1, 8, -7, 0, -7, 0, -7, 0}}
	for _, testCase := range testCases {
		println(singleNumber(testCase))
		println()
	}
}
