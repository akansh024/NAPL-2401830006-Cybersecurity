package main

import "fmt"

type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

var items []Item

func addItem(id int, name string, quantity int, price float64) {
	item := Item{
		ID:       id,
		Name:     name,
		Quantity: quantity,
		Price:    price,
	}
	items = append(items, item)
	fmt.Println("Item added:", item)
}

func updateItem(id int, name string, quantity int, price float64) {
	for i, item := range items {
		if item.ID == id {
			items[i].Name = name
			items[i].Quantity = quantity
			items[i].Price = price
			fmt.Println("Item updated:", items[i])
			return
		}
	}
	fmt.Println("Item not found with ID:", id)
}

func removeItem(id int) {
	for i, item := range items {
		if item.ID == id {
			items = append(items[:i], items[i+1:]...)
			fmt.Println("Item removed with ID:", id)
			return
		}
	}
	fmt.Println("Item not found with ID:", id)
}

func main() {
	addItem(1, "Apple", 10, 1.5)
	addItem(2, "Banana", 5, 0.8)
	updateItem(1, "Green Apple", 15, 2.0)
	removeItem(2)
}
