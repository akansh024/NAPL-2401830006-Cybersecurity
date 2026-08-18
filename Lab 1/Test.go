/* Declare two integer and two float variables and perform addition,
subtraction, and multiplication using integer and floating-point types. */
/*package main

import "fmt"

func main() {
	intA := 12
	intB := 4
	floatA := 10.5
	floatB := 2.5

	fmt.Println("Integer Operations:")
	fmt.Printf("%d + %d = %d\n", intA, intB, intA+intB)
	fmt.Printf("%d - %d = %d\n", intA, intB, intA-intB)
	fmt.Printf("%d * %d = %d\n", intA, intB, intA*intB)

	fmt.Println()
	fmt.Println("Floating-Point Operations:")
	fmt.Printf("%.2f + %.2f = %.2f\n", floatA, floatB, floatA+floatB)
	fmt.Printf("%.2f - %.2f = %.2f\n", floatA, floatB, floatA-floatB)
	fmt.Printf("%.2f * %.2f = %.2f\n", floatA, floatB, floatA*floatB)
}
*/
/* Accept numeric input.
Perform addition, subtraction, and multiplication using integer types.
Perform addition, subtraction, and multiplication using floating-point types.
Use if statements and loops to validate the input (reject non-numeric or out-of-range values) and handle different scenarios */

package main

import "fmt"

func main() {
	for {
		var choice int

		fmt.Println("\nChoose an option:")
		fmt.Println("1. Integer operations")
		fmt.Println("2. Floating-point operations")
		fmt.Println("3. Exit")
		fmt.Print("Enter your choice: ")

		fmt.Scan(&choice)

		if choice == 1 {
			var a, b int

			fmt.Print("Enter first integer: ")
			fmt.Scan(&a)

			fmt.Print("Enter second integer: ")
			fmt.Scan(&b)

			fmt.Println("Addition:", a+b)
			fmt.Println("Subtraction:", a-b)
			fmt.Println("Multiplication:", a*b)

		} else if choice == 2 {
			var a, b float64

			fmt.Print("Enter first number: ")
			fmt.Scan(&a)

			fmt.Print("Enter second number: ")
			fmt.Scan(&b)

			fmt.Println("Addition:", a+b)
			fmt.Println("Subtraction:", a-b)
			fmt.Println("Multiplication:", a*b)

		} else if choice == 3 {
			fmt.Println("Program ended.")
			break

		} else {
			fmt.Println("Wrong choice! Please enter 1, 2, or 3.")
		}
	}
}
