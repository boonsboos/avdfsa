package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.Two
import kotlin.test.Test
import kotlin.test.assertEquals

class TwoTest {

    val two = Two()

    @Test
    fun `giftTax below bracket 1 is untaxed`() {
        // Arrange
        val giftAmount = 4_999

        // Act
        val result = two.calculateGiftTax(giftAmount)

        // Assert
        assertEquals(0.0, result)
    }

    @Test
    fun `giftTax in bracket 1 is 100`() {
        // Arrange
        val giftAmount = 5000

        // Act
        val result = two.calculateGiftTax(giftAmount)

        // Assert
        assertEquals(100.0, result)
    }

    @Test
    fun `giftTax in bracket 1 is 100 plus 8 percent of the bracket`() {
        // Arrange
        val giftAmount = 5100

        // Act
        val result = two.calculateGiftTax(giftAmount)

        // Assert
        assertEquals(108.0, result)
    }
}