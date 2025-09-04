package nl.boonsboos.lessontwo.one

class One {
    private val onlyWordRegex = Regex("[A-Za-z]+")
    private val onlyLetterRegex = Regex("[A-Za-z]")
    private val onlyDigitRegex = Regex("[0-9]")
    private val onlyWhitespaceRegex = Regex("\\s")
    private val onlyPunctuationRegex = Regex("[^A-Za-z0-9\\s]")

    fun getStatistics(text: String): TextStatistics {
        val onlyWords = onlyWordRegex.findAll(text)
        val onlyLetters = onlyLetterRegex.findAll(text)
        val onlyDigits = onlyDigitRegex.findAll(text)
        val onlyWhitespace = onlyWhitespaceRegex.findAll(text)
        val onlyPunctuations = onlyPunctuationRegex.findAll(text)

        return TextStatistics(
            text.length,
            text.lines().size,
            onlyWords.count(),
            onlyWhitespace.count(),
            onlyLetters.count(),
            onlyDigits.count(),
            onlyPunctuations.count(),
        )
    }
}
