package main

import "fmt"

type student struct {
	name  string
	marks float64
	age   int
}

func modifyAge(age *int) {
	*age = 25
}

func main() {

	age := 20

	fmt.Println("Value of age:", age)
	fmt.Println("Address of age:", &age)
	fmt.Println("Value using pointer:", *(&age))

	fmt.Println("\nBefore modification:", age)

	modifyAge(&age)

	fmt.Println("After modification:", age)

	s := new(student)
	s.name = "Diwakar"
	s.marks = 85.5
	s.age = 20

	fmt.Println("\nStudent details:")
	fmt.Println("Name:", s.name)
	fmt.Println("Marks:", s.marks)
	fmt.Println("Age:", s.age)

	s.marks = 92.5

	fmt.Println("\nAfter modifying marks:")
	fmt.Println("Marks:", s.marks)
}
