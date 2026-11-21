class Student(
    private var rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {
    fun readData() {
        print("Enter Roll No: ")
        rollNo = readln().trim().toIntOrNull() ?: 0
        
        print("Enter Name: ")
        name = readln().trim()
        
        print("Enter Course: ")
        course = readln().trim()
        
        print("Enter Percentage: ")
        percentage = readln().trim().toDoubleOrNull() ?: 0.0
    }

    fun displayData() {
        println("-----------------------------------")
        println("Student Details:")
        println("Roll No    : $rollNo")
        println("Name       : $name")
        println("Course     : $course")
        println("Percentage : $percentage%")
        println("-----------------------------------")
    }
}

fun main() {
    println("--- Student 1 Setup ---")
    val student1 = Student(0, "", "", 0.0)
    student1.readData()
    
    println("\n--- Student 2 Setup ---")
    val student2 = Student(0, "", "", 0.0)
    student2.readData()

    println("\n=== Displaying Student Data ===")
    student1.displayData()
    student2.displayData()
}