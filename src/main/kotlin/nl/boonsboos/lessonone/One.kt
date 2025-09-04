package nl.boonsboos.lessonone

class One {

    fun sum(number1: Int, number2: Int, number3: Int, number4: Int): Int {
        return number1 + number2 + number3 + number4
    }

    fun average(number1: Int, number2: Int, number3: Int, number4: Int): Double {
        return sum(number1, number2, number3, number4) / 4.0
    }

}