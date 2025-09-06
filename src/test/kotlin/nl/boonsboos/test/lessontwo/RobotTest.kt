package nl.boonsboos.test.lessontwo

import nl.boonsboos.lessontwo.two.Robot
import kotlin.test.Test
import kotlin.test.assertEquals

class RobotTest {
    @Test
    fun `robot up wraps correctly`() {
        // Arrange
        val robot: Robot = Robot(10)

        // Act
        robot.up(10)

        // Assert
        assertEquals(0, robot.y)
    }

    @Test
    fun `robot down wraps correctly`() {
        // Arrange
        val robot: Robot = Robot(10) // 0 to 9

        // Act
        robot.down(1)

        // Assert
        assertEquals(9, robot.y) // 0 to 9
    }

    @Test
    fun `robot right wraps correctly`() {
        // Arrange
        val robot: Robot = Robot(10) // 0 to 9

        // Act
        robot.right(10)

        // Assert
        assertEquals(0, robot.x)
    }

    @Test
    fun `robot left wraps correctly`() {
        // Arrange
        val robot: Robot = Robot(10) // 0 to 9

        // Act
        robot.left(1)

        // Assert
        assertEquals(9, robot.x)
    }
}