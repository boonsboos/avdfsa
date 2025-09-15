package nl.boonsboos.lessonfour

// Van https://play.kotlinlang.org/koans/Collections/

class One {

    // toSet

    fun Shop.getSetOfCustomers(): Set<Customer> {
        return this.customers.toSet()
    }

    // Sorting

    fun Shop.getCustomersSortedByOrders(): List<Customer> {
        return this.customers.sortedByDescending { it.orders.size }
    }

    // Map and filter

    fun Shop.getCustomerCities(): Set<City> {
        return this.customers.map { it.city }.toSet()
    }

    fun Shop.getCustomersInCity(city: City): List<Customer> {
        return this.customers.filter { it.city.name == city.name }
    }

    // Any and all

    fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
        return this.customers.all { it.city.name == city.name }
    }

    fun Shop.hasCustomerFrom(city: City): Boolean {
        return this.customers.any { it.city.name == city.name }
    }

    fun Shop.countCustomersFrom(city: City): Int {
        return this.customers.count { it.city.name == city.name }
    }

    fun Shop.countCustomerFrom(city: City): Customer? {
        return this.customers.find { it.city.name == city.name }
    }

    // Association

    fun Shop.nameToCustomerMap(): Map<String, Customer> {
        return this.customers.associateBy { it.name }
    }

    fun Shop.customerToCityMap(): Map<Customer, City> {
        return this.customers.associateWith { it.city }
    }

    fun Shop.customerNameToCityMap(): Map<String, City> {
        return this.customers.associate { it.name to it.city }
    }

    // GroupBy

    fun Shop.groupCustomersByCity(): Map<City, List<Customer>> {
        return this.customers.groupBy { it.city }
    }

    // Partition

    fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
        return this.customers.filter { customer ->
            val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
        }.toSet()
    }

    // FlatMap

    fun Customer.getOrderedProducts(): List<Product> {
        return this.orders.flatMap { it.products }
    }

    fun Shop.getOrderedProducts(): Set<Product> {
        return this.customers.flatMap { it.getOrderedProducts() }.toSet()
    }

    // Minmax

    fun Shop.getCustomerWithMaxOrders(): Customer? {
        return this.customers.maxByOrNull { it.orders.size }
    }

    fun Customer.getOrderedProductsSet(): Set<Product> {
        return this.getOrderedProducts().toSet()
    }

    fun getMostExpensiveProductBy(customer: Customer): Product? {
        return customer.getOrderedProductsSet().maxByOrNull { it.price }
    }

    // Sum

    fun moneySpentBy(customer: Customer): Double {
        return customer.getOrderedProducts().sumOf { it.price }
    }

    // Fold & reduce

    // Deze was best pittig.
    // Ik snap het als je het niet in één keer begrijpt.
    fun Shop.getProductsOrderedByAll(): Set<Product> {
        // Mijn oplossing:
        // return this.customers.fold(setOf()) { acc, customer -> acc intersect customer.getOrderedProducts() }
        // Dit verzamelt in een vooraf aangemaakte set.

        // Een lijst van producten die door een klant zijn gekocht
        val allOrderedProducts = customers.map{ it.getOrderedProductsSet() }

        // Breng het terug tot een set van unieke producten
        return allOrderedProducts.reduce { allOrdered, customerOrdered ->
            allOrdered intersect customerOrdered
        }
    }

    // Compound tasks oftewel: alles door elkaar

    fun findMostExpensiveProductBy(customer: Customer): Product? {
        return customer.orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .maxByOrNull { it.price }
    }

    fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
        return this.customers.flatMap { it.getOrderedProducts() }
            .count { it == product }
    }

    // Sequences
    // Zorgen voor (mogelijk) parallelle verwerking.
    // Omdat een filter of (flat)map geen staat bij hoeft te houden hoef je geen rekening te houden met synchronisatie.

    fun findMostExpensiveProductBySequenceEdition(customer: Customer): Product? {
        // Mijn oplossing
        return customer.orders.asSequence()
            .filter { it.isDelivered}
            .flatMap { it.products }
            .maxByOrNull { it.price }
    }

    fun Shop.getNumberOfTimesProductWasOrderedSequenceEdition(product: Product): Int {
        // Mijn oplossing
        return this.customers.asSequence()
            .flatMap { customer -> customer.orders.asSequence() }
            .flatMap { order -> order.products}
            .count { it == product }
    }

    // Laatste

    fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
        val groupsByLength = collection.groupBy { it.length }
        val maximumSizeOfGroup = groupsByLength.values.maxOfOrNull { it.size }

        return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup }
    }
}