data class Student(val name: String, val percentage: Int)

fun main() {

    val list = listOf("Akansh", "Aditya", "Hrishit")
    println("Read-only List: $list")
    println(list.contains("Akansh"))
    println(list.get(0))

    val mList = mutableListOf("Akansh", "Aditya", "Hrishit")
    mList.add("Kartikey")
    mList.remove("Aditya")
    println("Mutable List: $mList")
    println(mList.contains("Hrishit"))
    println(mList.get(1))

    val set = setOf("Akansh", "Aditya", "Adam")
    println("\nRead-only Set: $set")
    println(set.contains("Adam"))

    val mSet = mutableSetOf("Akansh", "Aditya", "Adam")
    mSet.add("Kartikey")
    mSet.remove("Aditya")
    println("Mutable Set: $mSet")
    println(mSet.contains("Kartikey"))

    val map = mapOf(1 to "Akansh", 2 to "Aditya")
    println("\nRead-only Map: $map")
    println(map.containsKey(1))
    println(map.get(2))

    val mMap = mutableMapOf(1 to "Akansh", 2 to "Aditya")
    mMap.put(3, "Hrishit")
    mMap.remove(2)
    println("Mutable Map: $mMap")
    println(mMap.containsKey(3))
    println(mMap.get(3))

    val numbers = listOf(1, 2, 3, 4, 5)

    println("\nOriginal List: $numbers")

    val mapped = numbers.map { it * 2 }
    println("Map: $mapped")

    val filtered = mapped.filter { it > 5 }
    println("Filter: $filtered")

    val reduced = filtered.reduce { a, b -> a + b }
    println("Reduce: $reduced")

    val students = listOf(
        Student("Akansh", 95),
        Student("Aditya", 80),
        Student("Hrishit", 70),
        Student("Kartikey", 85),
        Student("Adam", 65)
    )

    println("\nAscending Order:")
    println(students.sortedBy { it.percentage })

    println("\nDescending Order:")
    println(students.sortedByDescending { it.percentage })

    println("\nGrouped Students:")
    println(students.groupBy {
        if (it.percentage >= 75) "Distinction" else "Others"
    })
}