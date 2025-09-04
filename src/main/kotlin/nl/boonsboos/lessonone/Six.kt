package nl.boonsboos.lessonone

class Six {
    /* Als je wel gebruikersinvoer hebt, zou je het zo op kunnen lossen:

        var students: MutableList<String> = mutableListOf()
        var currentStudent = readln()
        while (!currentStudent.equals("end")) {
            students.add(currentStudent)

            var currentStudent = readln()
        }
        return students
     */
    // de zonder-input-oplossing:
    // Studenten worden met \n afgescheiden dus we kunnen standaardfuncties gebruiken
    fun readStudents(students: String): List<String> {
        return students.lines().dropLast(1) // alle regels - de laatste regel met "end" erin
    }

    fun listStudents(students: List<String>): String {
        val sb = StringBuilder()

        for (i in 0..<students.size) {
            sb.append("${i+1}. ${students[i]}\n")
        }

        return sb.toString()
    }

}