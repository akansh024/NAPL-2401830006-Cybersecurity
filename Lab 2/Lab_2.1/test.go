package main

import (
	mylib "custompackage/Mylib"
	"fmt"
)

func main() {
	str := "Hello World"

	fmt.Println("Original String:", str)
	fmt.Println("Reversed String:", mylib.Reverse(str))
	fmt.Println("Number of Vowels:", mylib.CountVowels(str))

	fmt.Println("Factorial of 5:", mylib.Factorial(5))
	fmt.Println("2 raised to power 3:", mylib.Power(2, 3))
}
