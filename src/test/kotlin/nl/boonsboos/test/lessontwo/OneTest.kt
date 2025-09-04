package nl.boonsboos.test.lessontwo

import nl.boonsboos.lessontwo.one.One
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertEquals

class OneTest {
    val one: One = One()

    @Test
    fun testGetStatistics() {
        // Arrange
        val testText = """
            Text statistieken achterhalen,
            is met in Kotlin 1.9.10 eenvoudig.
            En natuurlijk ook in oudere versies zoals:
            in Kotlin 1.6, Kotlin 1.7, Kotlin 1.8.20 
            Gebruik de when { ... } om
            met c.isWhitespace en c.isLetter(),
            en andere handige functies te tellen
            hoeveel witruimte, letters, ... er zijn.
        """.trimIndent()

        // Act
        val result = one.getStatistics(testText)

        // Assert
        assertEquals(8, result.nrOfLines)
        assertEquals(12, result.nrOfDigits)
        assertEquals(testText.length, result.textLength)
        assertEquals(27, result.nrOfOther)
        assertEquals(46, result.nrOfWhiteSpace)
        assertEquals(206, result.nrOfLetters)
        assertEquals(40, result.nrOfWords)
    }

    @Test
    fun testGetStatistics_ButTextIsGrammaticallyCorrect() {
        // Arrange
        val correctText = """
            Text statistieken achterhalen,
            is met Kotlin 1.9.10 eenvoudig.
            En natuurlijk ook in oudere versies zoals
            in Kotlin 1.6, Kotlin 1.7, Kotlin 1.8.20 
            Gebruik de when { ... } om
            met c.isWhitespace en c.isLetter(),
            en andere handige functies te tellen
            hoeveel witruimte, letters, ... er zijn.
        """.trimIndent()

        // Act
        val result = one.getStatistics(correctText)

        // Assert
        assertEquals(8, result.nrOfLines)
        assertEquals(12, result.nrOfDigits)
        assertEquals(correctText.length, result.textLength)
        assertEquals(26, result.nrOfOther)
        assertEquals(45, result.nrOfWhiteSpace)
        assertEquals(204, result.nrOfLetters)
        assertEquals(39, result.nrOfWords)
    }
}