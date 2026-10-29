package main

import (
	"fmt"
	"math"
	"strings"
)

func divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("division by zero")
	}
	return a / b, nil
}

func sqrt(n float64) (float64, error) {
	if n < 0 {
		return 0, fmt.Errorf("negative square root")
	}
	return math.Sqrt(n), nil
}

func checkInput(s string) (string, error) {
	s = strings.TrimSpace(s)
	if s == "" {
		return "", fmt.Errorf("empty input")
	}
	return s, nil
}

func main() {
	fmt.Println(divide(10, 2))
	fmt.Println(divide(10, 0))
	fmt.Println(sqrt(25))
	fmt.Println(sqrt(-4))
	fmt.Println(checkInput("Hello"))
	fmt.Println(checkInput(""))
}
