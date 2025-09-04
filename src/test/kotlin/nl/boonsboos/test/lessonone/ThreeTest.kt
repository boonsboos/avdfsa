package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.Three
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class ThreeTest {
    val three: Three = Three()

    private val sizeComparison = listOf(
        1, 2, 3, 4, 5, 6, 100
    )

    @Test
    fun `table size is equal to input`() {
        // Arrange
        sizeComparison.map {
            // Act
            val result = three.multiplicationTable(it)

            // Assert
            assertEquals(it, result.size, "Size ${result.size} is not equal to the input $it")
        }
    }

    @Test
    fun `table computes test case correctly`() {
        // Arrange
        val expectation = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(2, 4, 6),
            arrayOf(3, 6, 9)
        )

        // Act
        val result = three.multiplicationTable(3)

        // Assert
        assertArrayEquals(expectation, result, "Expected output differs from reality: $result")
    }
}