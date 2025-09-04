package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.One
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class OneTest {

    val one: One = One()

    @Test
    fun `sum of numbers correct`() {
        // Act
        val result = one.sum(1,1,1,1)

        // Assert
        assertEquals(4, result, "1 + 1 + 1 + 1 should always equal 4")
    }

    @Test
    fun `average of 4 numbers correct`() {
        // Act
        val result = one.average(1,1,1,1)

        // Assert
        assertEquals(1.0, result, "(1 + 1 + 1 + 1) / 4 should always equal 1")
    }
}