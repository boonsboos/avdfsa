package nl.boonsboos.lessonone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SixTest {
    val six: Six = Six()

    @Test
    fun readStudents() {
        // Arrange
        val input =
            """
                Jan Jansen
                Piet Pieterse
                end
            """.trimIndent()


        // Act
        val students = six.readStudents(input)

        // Assert
        assertEquals(2, students.size, students.joinToString())
    }

    @Test
    fun listStudents() {
        // Arrange
        val expectation =
            """
                1. Jan Jansen
                2. Piet Pieterse
            """.trimIndent() + "\n" // Laatse newline is onderdeel van de verwachte output

        val input =
            """
                Jan Jansen
                Piet Pieterse
                end
            """.trimIndent()

        val students = six.readStudents(input)

        // Act
        val list = six.listStudents(students)

        // Assert
        assertEquals(expectation, list)
    }

}