package nl.boonsboos.lessonone

class Two {

    private val bracketMinimumTax = listOf<Int>(
        0,
        100,
        1_700,
        4_700,
        22_100,
        142_100
    )

    private val bracketMinimum = listOf<Int>(
        0,
        5_000,
        25_000,
        55_000,
        200_000,
        1_000_000
    )

    private val bracketTaxRate = listOf<Double>(
        0.0,
        0.08,
        0.1,
        0.12,
        0.15,
        0.17
    )

    fun calculateGiftTax(gift: Int): Double {
        val bracket = findBracket(gift);
        return bracketMinimumTax[bracket] + ((gift - bracketMinimum[bracket]) * bracketTaxRate[bracket])
    }

    private fun findBracket(gift: Int): Int =
        when {
            gift >= 1_000_000              -> 5
            gift in 200_000..999_999 -> 4
            gift in 55_000..199_999  -> 3
            gift in 25_000..54_999   -> 2
            gift in 5_000..24_999    -> 1
            else                           -> 0
        }
}