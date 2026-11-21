// Task2.kt
fun main() {
    print("Enter department code (IT / HR / FIN / SALES): ")
    val deptCode = readln().trim().uppercase()

    print("Enter years of experience: ")
    val years = readln().trim().toIntOrNull()
    if (years == null) {
        println("Invalid years input.")
        return
    }

    print("Enter base salary: ")
    val salary = readln().trim().toDoubleOrNull()
    if (salary == null) {
        println("Invalid salary input.")
        return
    }

    // `when` is used as an expression: it returns the bonus rate (as a fraction)
    val bonusRate = when (deptCode) {
        "IT"    -> if (years > 5) 0.20 else 0.10   // IT  : >5 yrs -> 20%, otherwise 10%
        "HR"    -> if (years > 3) 0.15 else 0.08   // HR  : >3 yrs -> 15%, otherwise 8%
        "FIN"   -> if (years > 4) 0.18 else 0.09   // FIN : >4 yrs -> 18%, otherwise 9%
        "SALES" -> if (years > 2) 0.12 else 0.05   // SALES: >2 yrs -> 12%, otherwise 5%
        else    -> 0.10                            // All other departments -> 10%
    }

    val bonus = salary * bonusRate

    println("-------------------------------------")
    println("Department        : $deptCode")
    println("Years of experience: $years")
    println("Bonus rate        : ${(bonusRate * 100).toInt()}%")
    println("Base salary       : ${"%.2f".format(salary)}")
    println("Bonus amount      : ${"%.2f".format(bonus)}")
}