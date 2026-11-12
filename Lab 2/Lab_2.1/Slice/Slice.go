package main

import "fmt"

func main() {
	students := []string{"Rahul", "Aman", "Priya"}

	fmt.Println("Original Slice:", students)

	// Add an element
	students = append(students, "Akash")
	fmt.Println("After Adding:", students)

	// Remove an element by index
	index := 1
	students = append(students[:index], students[index+1:]...)
	fmt.Println("After Removing:", students)

	// Update an element
	students[1] = "Rohit"
	fmt.Println("After Updating:", students)
}
