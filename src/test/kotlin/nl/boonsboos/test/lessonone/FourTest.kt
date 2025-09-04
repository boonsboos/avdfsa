package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.Four
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class FourTest {
    val four: Four = Four()

    @Test
    fun `even numbers up to and including parameter`() {
        // Arrange
        val expectation = 30

        // Act
        val result = four.sumOfEven(10)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun `count of digits in string`() {
        // Arrange
        val expectation = 5

        // Act
        val result = four.countDigits("There are five digits in this string: 12345")

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun `strip anything but letters from string`() {
        // Arrange
        val expectation = "Therearefivedigitsinthisstring"

        // Act
        val result = four.onlyLetters("There are five digits in this string: 12345")

        // Assert
        assertEquals(expectation, result)
    }
}