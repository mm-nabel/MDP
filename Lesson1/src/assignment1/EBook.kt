package assignment1

class EBook(title: String, author: String, price: Double, var filetype: String) : Book(title, author, price) {
    override fun read() {
        println("Read from Electronic Device")
    }
}