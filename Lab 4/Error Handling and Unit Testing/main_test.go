package main

import "testing"

func TestDivide(t *testing.T) {
	if n, err := divide(10, 2); err != nil || n != 5 {
		t.Error("Division failed")
	}
	if _, err := divide(10, 0); err == nil {
		t.Error("Expected division error")
	}
}

func TestSqrt(t *testing.T) {
	if n, err := sqrt(25); err != nil || n != 5 {
		t.Error("Square root failed")
	}
	if _, err := sqrt(-4); err == nil {
		t.Error("Expected square root error")
	}
}

func TestInput(t *testing.T) {
	if s, err := checkInput("Go"); err != nil || s != "Go" {
		t.Error("Valid input failed")
	}
	if _, err := checkInput(""); err == nil {
		t.Error("Expected empty input error")
	}
}
