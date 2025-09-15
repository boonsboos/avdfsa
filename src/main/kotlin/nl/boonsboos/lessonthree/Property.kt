package nl.boonsboos.lessonthree

import java.time.Instant
import kotlin.random.Random

sealed class Property(val address: String, val livingArea: Int, var priceAsked: Int?) : Locatable {
    private val _allBids: MutableList<Bid> = mutableListOf()
    val allBids: List<Bid> get() = _allBids.toList()

    val images: MutableList<Picture> = mutableListOf()

    fun doOffer(customer: Customer, priceOffered: Int): Unit {
        if (isAccepted(priceOffered)) {
            this._allBids.add(Bid(customer, priceOffered, Instant.now()))
            // Sorteer alle boden van groot naar klein
            _allBids.sortWith(
                Comparator { a: Bid, b: Bid -> b.priceOffered - a.priceOffered }
            )
        }
    }

    private fun isAccepted(priceOffered: Int): Boolean {
        require(priceOffered >= 0) {"Prijs mag niet negatief zijn"}
        if (_allBids.isEmpty()) return true

        // Hoogste bod is altijd het eerste
        return priceOffered > _allBids.first().priceOffered
    }

    abstract fun getMonthlyPayments(): Int?

    override fun getLocation(): LatLong {
        return LatLong(
            51.58494229691791 + Random.nextDouble(-0.1, 0.1),
            4.797559120743779 + Random.nextDouble(-0.1, 0.1)
        )
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} at $address" +
                " price: ${priceAsked ?: "price information on request."} living area: $livingArea" +
                "\n\testimated monthly costs (mortgage, energy, maintenance): ${getMonthlyPayments()}"
    }
}