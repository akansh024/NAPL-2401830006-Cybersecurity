import kotlin.math.abs

fun main() {
    print("Enter an integer: ")
    val input = readln().trim()

    val number = input.toLongOrNull()
    if (number == null) {
        println("Invalid integer input.")
        return
    }

    // Convert to absolute value, then to its individual digits
    val digits = abs(number).toString().map { it.digitToInt() }
    val average = digits.average()

    println("Number          : $number")
    println("Digits          : ${digits.joinToString(", ")}")
    println("Digit count     : ${digits.size}")
    println("Average of digits: ${"%.2f".format(average)}")
}