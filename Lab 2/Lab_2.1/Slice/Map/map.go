package main

import "fmt"

func main() {
	marks := map[string]int{
		"Maths":   85,
		"Science": 90,
		"English": 78,
	}

	fmt.Println("Original Map:", marks)

	// Insert a new key-value pair
	marks["Computer"] = 95
	fmt.Println("After Inserting:", marks)

	// Delete a key-value pair
	delete(marks, "English")
	fmt.Println("After Deleting:", marks)

	// Lookup a value using its key
	value, exists := marks["Maths"]

	if exists {
		fmt.Println("Maths Marks:", value)
	} else {
		fmt.Println("Maths not found")
	}

	fmt.Println("Final Map:", marks)
}
