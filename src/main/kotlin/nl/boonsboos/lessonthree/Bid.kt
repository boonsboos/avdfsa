package nl.boonsboos.lessonthree

data class Bid(val customer: Customer, val priceOffered: Int, val timeOfBid: java.time.Instant)
