package mylib

import "strings"

func Reverse(s string) string {
	runes := []rune(s)

	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}

	return string(runes)
}

func CountVowels(s string) int {
	count := 0
	s = strings.ToLower(s)

	for _, ch := range s {
		if strings.ContainsRune("aeiou", ch) {
			count++
		}
	}

	return count
}

func Factorial(n int) int {
	if n < 0 {
		return -1
	}

	result := 1
	for i := 2; i <= n; i++ {
		result *= i
	}

	return result
}

func Power(base, exponent int) int {
	result := 1

	for i := 0; i < exponent; i++ {
		result *= base
	}

	return result
}
