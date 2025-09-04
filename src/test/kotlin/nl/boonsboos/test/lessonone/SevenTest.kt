package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.seven.Seven
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SevenTest {
    val seven: Seven = Seven()

    @Test
    fun testReadStudents() {
        // Arrange
        val input =
            """
                Jan Jansen
                1999
                Piet Pieterse
                2000
                end
            """.trimIndent()


        // Act
        val students = seven.readStudents(input)

        // Assert
        assertEquals(2, students.size)

        assertEquals("Jan Jansen", students[0].name)
        assertEquals(2000, students[1].yearBorn)
    }

    @Test
    fun testListStudents() {
        val expectation =
            """
                1. Jan Jansen is born in 1999
                2. Piet Pieterse is born in 2000
            """.trimIndent() + "\n" // Laatse newline is onderdeel van de verwachte output

        val input =
            """
                Jan Jansen
                1999
                Piet Pieterse
                2000
                end
            """.trimIndent()

        val students = seven.readStudents(input)

        // Act
        val list = seven.listStudents(students)

        // Assert
        assertEquals(expectation, list)
    }

}