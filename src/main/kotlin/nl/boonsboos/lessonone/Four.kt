package nl.boonsboos.lessonone

import kotlin.text.iterator

class Four {

    fun sumOfEven(max: Int): Int {
        if (max == 2) return 2

        var accumulator = 0
        for (i in 2..max) {
            if (i % 2 == 0) accumulator += i
        }
        return accumulator
    }

    fun countDigits(input: String): Int {
        var accumulator = 0
        for (c in input) {
            if (c.isDigit()) accumulator++
        }
        return accumulator
    }

    // matcht alles wat NIET a tot z of A to Z is
    private val letterOnlyRegex = Regex("[^a-zA-Z]")

    // vervangt alles wat de regex matcht in de input met lege string
    fun onlyLetters(input: String): String = input.replace(letterOnlyRegex, "")
}