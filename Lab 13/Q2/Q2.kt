fun printEmployeeDetails(
    name: String, 
    age: Int = 25, 
    department: String = "IT" 
) {
    println("Name: $name | Age: $age | Dept: $department")
}

fun printNumbers(vararg numbers: Int) {
    print("Received numbers: ")
    for (num in numbers) {
        print("$num ")
    }
    println() 
}

fun applyFunctionToList(numbers: List<Int>, operation: (Int) -> Int): List<Int> {
    val resultList = mutableListOf<Int>()
    for (num in numbers) {
        resultList.add(operation(num)) 
    }
    return resultList
}

fun main() {
    println("--- (1) Function with Default Parameters ---")
    print("Without defaults: ")
    printEmployeeDetails("Alice")
    
    print("With defaults:    ")
    printEmployeeDetails("Bob", 30, "Finance")

    println("\n--- (2) Function using Named Arguments ---")
    print("Out of order:     ")
    printEmployeeDetails(department = "HR", name = "Charlie")

    println("\n--- (3) Function with vararg ---")
    printNumbers(10, 20, 30, 40, 50)
    printNumbers(1, 2)

    println("\n--- (4) Higher-Order Function (Lambdas) ---")
    val baseNumbers = listOf(1, 2, 3, 4, 5)
    println("Original list: $baseNumbers")

    val doubledList = applyFunctionToList(baseNumbers) { it * 2 }
    println("Doubled list:  $doubledList")

    val squaredList = applyFunctionToList(baseNumbers) { it * it }
    println("Squared list:  $squaredList")
}