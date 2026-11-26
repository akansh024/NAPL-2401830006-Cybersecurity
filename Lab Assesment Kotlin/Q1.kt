data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val instructor: String?
)

data class Student(
    val id: Int,
    val name: String,
    val email: String?,
    val courses: MutableList<Course> = mutableListOf()
)

fun Course.label(): String {
    val prof = instructor ?: "TBA"
    return "$code - $title ($credits cr, $prof)"
}

fun Student.totalCredits(): Int = courses.map { it.credits }.sum()

fun Student.summary(): String {
    val mail = email ?: "no-email"
    return "$name ($mail) -> ${totalCredits()} credits"
}

class ReportBuilder {
    private val sb = StringBuilder()

    fun heading(text: String) {
        sb.append("=== $text ===\n")
    }

    fun line(text: String) {
        sb.append("$text\n")
    }

    fun build(): String = sb.toString()
}

fun report(init: ReportBuilder.() -> Unit): String = ReportBuilder().apply(init).build()

class RegistrationDSL {
    val courses = mutableListOf<Course>()
    val students = mutableListOf<Student>()

    fun course(code: String, title: String, credits: Int, instructor: String? = null) {
        courses.add(Course(code, title, credits, instructor))
    }

    fun student(id: Int, name: String, email: String? = null, vararg codes: String) {
        val enrolled = courses.filter { it.code in codes }.toMutableList()
        students.add(Student(id, name, email, enrolled))
    }
}

fun registration(init: RegistrationDSL.() -> Unit): RegistrationDSL = RegistrationDSL().apply(init)

fun main() {
    val system = registration {
        course("CS101", "Clojure", 4, "Dr. Rao")
        course("CS102", "Kotlin", 3, null)
        course("CS103", "Databases", 4, "Dr. Sen")

        student(1, "Akansh", "akansh@uni.edu", "CS101", "CS102")
        student(2, "Hrishit", null, "CS101", "CS103")
        student(3, "Aditya", "aditya@uni.edu", "CS102")
        student(4, "Kartikey", null)
    }

    val activeStudents = system.students.filter { it.totalCredits() > 0 }
    val activeNames = activeStudents.map { it.name }
    val allCredits = activeStudents.map { it.totalCredits() }.reduce { acc, c -> acc + c }
    val grouped = system.students.groupBy { if (it.totalCredits() >= 4) "Full-Time" else "Part-Time" }

    val output = report {
        heading("Course Catalogue")
        system.courses.forEach { line(it.label()) }

        heading("Students")
        system.students.forEach { line(it.summary()) }

        heading("Analytics")
        line("Active Students: $activeNames")
        line("Total Enrolled Credits: $allCredits")
        line("Full-Time: ${grouped["Full-Time"]?.map { it.name }}")
        line("Part-Time: ${grouped["Part-Time"]?.map { it.name }}")
    }

    println(output)
}