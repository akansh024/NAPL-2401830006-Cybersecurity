package main

import (
	"fmt"
)

type result struct {
	Operation string
	Value     int
}

func squares(n int, results chan<- result) {
	fmt.Println("square goroutine started")
	results <- result{"square", n * n}
	fmt.Println("square goroutine completed")
}
func cubes(n int, results chan<- result) {
	fmt.Println("cube goroutine started")
	results <- result{"cube", n * n * n}
	fmt.Println("cube goroutine completed")
}

func reverseDigits(n int) int {
	reversed := 0
	for n > 0 {
		reversed = reversed*10 + n%10
		n /= 10
	}
	return reversed
}

func fibonacci(n int, results chan<- result) {
	fmt.Println("Fibonacci goroutine started")
	a, b := 0, 1
	for i := 0; i < n; i++ {
		a, b = b, a+b
	}
	results <- result{"Fibonacci", reverseDigits(a)}
	fmt.Println("Fibonacci goroutine completed")

}
func main() {
	const number = 6
	results := make(chan result, 3)

	go squares(number, results)
	go cubes(number, results)
	go fibonacci(number, results)

	for i := 0; i < 3; i++ {
		computed := <-results
		fmt.Printf("%s of %d = %d\n", computed.Operation, number, computed.Value)
	}
}
