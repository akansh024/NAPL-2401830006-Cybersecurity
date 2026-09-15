package main

import "fmt"

type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}

func (p Person) Printdetails() {
	fmt.Printf("Name: %s\nAge: %d\nJob: %s\nSalary: %.2f\n", p.Name, p.Age, p.Job, p.Salary)
}

func (p *Person) Readinputs() {
	fmt.Print("Enter name: ")
	fmt.Scan(&p.Name)

	fmt.Print("Enter age: ")
	fmt.Scan(&p.Age)

	fmt.Print("Enter job: ")
	fmt.Scan(&p.Job)

	fmt.Print("Enter salary: ")
	fmt.Scan(&p.Salary)
}

func main() {
	var person1 Person
	var person2 Person

	fmt.Println("Person 1")
	person1.Readinputs()
	fmt.Println("Person 2")
	person2.Readinputs()

	fmt.Println("\nPerson Details")
	person1.Printdetails()
	person2.Printdetails()
}
