package nl.boonsboos.lessontwo.two

/**
 * @param fieldSize the size of the field the robot can walk on. Coordinates are zero-indexed
 */
class Robot(
    val fieldSize: Int = 100,
    var x: Int = 0,
    var y: Int = 0
)
{
    private fun Int.wrappingRobotAddition(add: Int): Int {
        if (this + add >= fieldSize) {
            return ((this + add) % fieldSize)
        }
        return this + add
    }

    private fun Int.wrappingRobotSubtraction(sub: Int): Int {
        if (this - sub < 0) {
            return fieldSize + ((this - sub) % fieldSize) // zo halen we de min weg
        }
        return this - sub
    }

    fun right(steps: Int) {
        x = x.wrappingRobotAddition(steps)
    }

    fun left(steps: Int) {
        x = x.wrappingRobotSubtraction(steps)
    }

    fun down(steps: Int) {
        y = y.wrappingRobotSubtraction(steps)
    }

    fun up(steps: Int) {
        y = y.wrappingRobotAddition(steps)
    }

    override fun toString(): String = "($x, $y)"
}