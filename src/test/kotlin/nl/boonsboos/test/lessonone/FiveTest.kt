package nl.boonsboos.test.lessonone

import nl.boonsboos.lessonone.Five
import nl.boonsboos.lessonone.Five.Side
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class FiveTest {

    val five: Five = Five()

    @Test
    fun testChristmasTree() {
        // Arrange
        val expectation =
"""         *
        ***
       *****
      *******
     *********
    ***********
   *************
  ***************
 *****************
*******************
        ***
        ***
"""

        // Act
        val result = five.christmasTree(9)

        // Assert
        assertEquals(expectation, result, "Santa is sad....")
    }

    @Test
    fun testSquare() {
        // Arrange
        val expectation =
"""***
***
***
"""
        // Act
        val result = five.square(3)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun testRectangle() {
        // Arrange
        val expectation =
"""***
***
***
"""
        // Act
        val result = five.rectangle(3, 3)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun testSpaces() {
        // Arrange
        val expectation = "   "

        // Act
        val result = five.spaces(3)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun testStars() {
        // Arrange
        val expectation = "***\n"

        // Act
        val result = five.stars(3)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun testTriangleLeft() {
        // Arrange
        val expectation =
"""*
**
***
"""

        // Act
        val result = five.triangle(3, Side.LEFT)

        // Assert
        assertEquals(expectation, result)
    }

    @Test
    fun testTriangleRight() {
        // Arrange
        val expectation =
"""  *
 **
***
"""

        // Act
        val result = five.triangle(3, Side.RIGHT)

        // Assert
        assertEquals(expectation, result)
    }
}