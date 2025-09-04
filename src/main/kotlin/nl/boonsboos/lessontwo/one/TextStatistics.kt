package nl.boonsboos.lessontwo.one

data class TextStatistics (
    val textLength: Int = 0,
    val nrOfLines: Int = 0,
    val nrOfWords: Int = 0,
    val nrOfWhiteSpace: Int = 0,
    val nrOfLetters: Int = 0,
    val nrOfDigits: Int = 0,
    val nrOfOther: Int = 0
) {
    override fun toString(): String {
        return "The text contains:\n\t$textLength characters " +
                "($nrOfLetters letters, $nrOfDigits digits, $nrOfWhiteSpace whitespaces, $nrOfOther other)" +
                "\n\t$nrOfLines lines\n\t$nrOfWords words"
    }
}