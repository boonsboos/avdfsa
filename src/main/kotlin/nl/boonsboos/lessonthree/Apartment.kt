package nl.boonsboos.lessonthree

class Apartment(
    address: String,
    livingArea: Int,
    priceAsked: Int?,
    val hoaPayment: Int,
    val floor: Int
) : Property(address, livingArea, priceAsked) {
    val energyCosts = livingArea * 9

    override fun getMonthlyPayments(): Int? {
        if (priceAsked == null) return null
        return (energyCosts + hoaPayment + (priceAsked!! * HousingMarket.INTEREST) / 12).toInt()
    }

    override fun toString(): String = super.toString() + "\n\tlocated at ${floor} floor"
}