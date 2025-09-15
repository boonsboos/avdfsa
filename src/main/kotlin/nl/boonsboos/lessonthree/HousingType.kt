package nl.boonsboos.lessonthree

enum class HousingType {
    DETACHED,
    SEMI_DETACHED,
    TERRACED,
    BUNGALOW
}

fun HousingType.getEnergyCost(): Int {
    return when (this) {
        HousingType.DETACHED, HousingType.BUNGALOW -> 15
        HousingType.SEMI_DETACHED -> 13
        HousingType.TERRACED -> 11
    }
}