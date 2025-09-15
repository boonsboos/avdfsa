package nl.boonsboos.lessonthree

class House (
    address: String,
    livingArea: Int,
    priceAsked: Int? = null,
    val type: HousingType,
    val plotArea: Int
) : Property(address, livingArea, priceAsked) {
    override fun getMonthlyPayments(): Int? {
        if (priceAsked == null) return null

        val maintenance = (priceAsked!! / 100) + (plotArea * 5)
        val mortgage = priceAsked!! * HousingMarket.INTEREST
        val energy = livingArea * type.getEnergyCost()
        return ((maintenance + mortgage + energy) / 12).toInt()
    }
}