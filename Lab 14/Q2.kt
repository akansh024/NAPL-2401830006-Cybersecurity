fun main() {

    val name: String = "Akansh"
    val student: String? = null

    println("Non-nullable: $name")
    println("Nullable: $student")

    println("Safe Call: ${student?.length}")

    val result = student ?: "Aditya"
    println("Elvis Operator: $result")

    try {
        println(student!!.length)
    } catch (e: NullPointerException) {
        println("NullPointerException caught")
    }
}