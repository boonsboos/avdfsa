package nl.boonsboos.lessonthree

class HousingMarket {
    private val properties: MutableList<Property> = mutableListOf()

    companion object {
        const val INTEREST: Double = 0.04
    }

    fun advertise(property: Property) =
        this.properties.add(property)

    fun advertise(properties: List<Property>) =
        this.properties.addAll(properties)

    fun search(query: (Property) -> Boolean): List<Property> {
        return this.properties.filter(query)
    }

    fun search(minPrice: Int = 0, maxPrice: Int = Int.MAX_VALUE): List<Property> {
        if (minPrice == 0 && maxPrice == Int.MAX_VALUE) return this.properties

        return this.properties.filter {
            it.priceAsked in minPrice..maxPrice
        }
    }
}