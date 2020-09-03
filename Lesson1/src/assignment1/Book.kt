package assignment1

open class Book(var title: String, var author: String, var price: Double) {
    open fun read() {
        println("Reading Paper book")
    }
}