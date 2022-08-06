package main

import (
	"fmt"
	"strconv"
)

const debug = false

var priority = map[byte]int{
	'+': 1,
	'-': 1,
	'*': 2,
	'/': 2,
}

func calculate(s string) int {
	nums := []int{}
	operators := []byte{}
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			continue
		}
		j := i
		for j < len(s) && s[j] >= '0' && s[j] <= '9' {
			j++
		}

		if j == i {
			if s[i] == '(' {
				count := 1
				for count != 0 {
					j++
					if s[j] == '(' {
						count++
					} else if s[j] == ')' {
						count--
					}
				}
				nums = append(nums, calculate(s[i+1:j]))
				i = j
			} else {
				for len(operators) > 0 && priority[operators[len(operators)-1]] >= priority[s[i]] {
					doOperate(&nums, operators[len(operators)-1])
					operators = operators[:len(operators)-1]
				}
				operators = append(operators, s[i])
			}
		} else {
			n, _ := strconv.Atoi(s[i:j])
			nums = append(nums, n)
			i = j - 1
		}
		if debug {
			fmt.Println(nums)
			for _, o := range operators {
				fmt.Print(string(o), " ")
			}
			fmt.Println()
		}
	}
	for len(operators) != 0 {
		doOperate(&nums, operators[len(operators)-1])
		operators = operators[:len(operators)-1]
		if debug {
			fmt.Println(nums)
			for _, o := range operators {
				fmt.Print(string(o), " ")
			}
			fmt.Println()
		}
	}

	return nums[0]
}

func doOperate(numsPtr *[]int, operator byte) {
	numsLen := len(*numsPtr)

	switch operator {
	case '+':
		if numsLen >= 2 {
			(*numsPtr)[numsLen-2] = (*numsPtr)[numsLen-1] + (*numsPtr)[numsLen-2]
			*numsPtr = (*numsPtr)[:numsLen-1]
		}
	case '-':
		if numsLen == 1 {
			(*numsPtr)[0] = -(*numsPtr)[0]
		} else if numsLen >= 2 {
			(*numsPtr)[numsLen-2] = (*numsPtr)[numsLen-2] - (*numsPtr)[numsLen-1]
			*numsPtr = (*numsPtr)[:numsLen-1]
		}
	case '*':
		if numsLen >= 2 {
			(*numsPtr)[numsLen-2] = (*numsPtr)[numsLen-2] * (*numsPtr)[numsLen-1]
			*numsPtr = (*numsPtr)[:numsLen-1]
		}
	case '/':
		if numsLen >= 2 {
			(*numsPtr)[numsLen-2] = (*numsPtr)[numsLen-2] / (*numsPtr)[numsLen-1]
			*numsPtr = (*numsPtr)[:numsLen-1]
		}
	}
}

func main() {
	testCases := []string{"+0", "-+9", "1-(-2)", "2-1 + 2",
		"(1+(4+5+2)-3)+(6+8)-9",
		"(((((9))+1)-2))", "(7)-(0)+(4)",
		"1*2-3/4+5*6-7*8+9/10"}
	for _, testCase := range testCases {
		fmt.Println(calculate(testCase))
	}
}
