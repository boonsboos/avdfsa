package nl.boonsboos.lessontwo.two

class Robot {
    var x = 0
    var y = 0

    fun right(steps: Int) {
        if (x + steps >= 100) {
            x += (x + steps % 100)
        } else {
            x += steps
        }
    }

    fun left(steps: Int) {
        if (x - steps <= 0) {
            x -= (x - steps % 100)
        } else {
            x -= steps
        }
    }

    fun down(steps: Int) {
        if ( y + steps >= 100) {
            y += (y + steps % 100)
        } else {
            y += steps
        }
    }

    fun up(steps: Int) {
        if (y - steps <= 0) {
            y -= (y - steps % 100)
        } else {
            y -= steps
        }
    }

    fun getLocation(): String = "($x, $y)"
}