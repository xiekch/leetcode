package main

import (
	"fmt"
	"math/rand"
)

func rand7() int {
	return rand.Intn(7) + 1
}

func rand10() int {
	for {
		a := rand7() - 1
		b := rand7()
		c := a*7 + b
		// fmt.Println(a, b, c)
		if c <= 40 {
			return c%10 + 1
		}
	}
}

func main() {
	res := make([]int, 11)
	for i := 0; i < 1000; i++ {
		res[rand10()]++
	}
	fmt.Println(res)
}
