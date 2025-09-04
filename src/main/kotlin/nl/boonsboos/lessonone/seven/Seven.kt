package nl.boonsboos.lessonone.seven

/**
 * Deze opdracht breidt opdracht 6 uit.
 * We kunnen dus een deel van de code van opdracht 6 hergebruiken.
 */
class Seven {

    fun readStudents(input: String): List<Student> {
        val studentInfo = input.lines()
        val students = mutableListOf<Student>()

        var i = 0
        while (i < studentInfo.size) {
            val name = studentInfo[i]
            if (name == "end") break
            i++

            val birthYear = studentInfo[i]
            if( birthYear == "end") break
            i++

            students.add(Student(name, birthYear.toInt()))
        }

        return students
    }

    fun listStudents(students: List<Student>): String {
        val sb = StringBuilder()

        for (i in students.indices) {
            sb.append( "${i+1}. ${students[i].name} is born in ${students[i].yearBorn}\n" )
        }

        return sb.toString()
    }
}