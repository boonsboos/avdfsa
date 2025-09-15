package nl.boonsboos.lessonthree

class Garage(
    address: String,
    livingArea: Int,
    priceAsked: Int? = null,
    val hasElectricity: Boolean = false
) : Property(address, livingArea, priceAsked) {
    override fun toString(): String =
        if (hasElectricity)
            super.toString() +"\n\t with electricity!"
        else
            super.toString()

    override fun getMonthlyPayments(): Int? {
        if (priceAsked == null) return null
        return ((priceAsked!! * HousingMarket.INTEREST) / 12).toInt()
    }
}