package assignment1

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        //3-a
        printLF(x)
        //3-b
        println("Sum = " + sumOddSq(x))

        //3-c
        println("Weight on Venus =" + findWeight("Venus", 120.0))
        println("Weight on Jupiter =" + findWeight("Jupiter", 120.0))
        println("Weight on Saturn =" + findWeight("Saturn", 120.0))
        println("Weight on Neptune =" + findWeight("Neptune", 120.0))
        println("Weight on Neptune =" + findWeight("Neptune", 120.0))


        //4 a,b,c Book, EBook
        val book = Book("Title", "Author", 20.50)
        book.read()
        val ebook: Book = EBook("Title", "Author", 20.50, "PDF")
        ebook.read()
    }

    fun printLF(arr: IntArray) {
        println("First: " + arr[0] + ", " + "Last: " + arr[arr.size - 1])
    }

    fun sumOddSq(arr: IntArray): Int {
        var sum = 0
        for (x in arr) {
            sum += if (x % 2 == 0) 0 else x * x
        }
        return sum
    }

    fun findWeight(planet: String?, weight: Double): Double {
        return when (planet) {
            "Venus" -> weight * 0.78
            "Mars" -> weight * 0.39
            "Jupiter" -> weight * 2.65
            "Saturn" -> weight * 1.17
            "Uranus" -> weight * 1.05
            "Neptune" -> weight * 1.23
            else -> weight
        }
    }
}