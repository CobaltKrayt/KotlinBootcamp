package Books

const val MBN = 5

fun main() {

//Pair Triple -----------------------------------------------------------------------------------------
    /*
    var greenbook = Book("Merry","Pippin",2020)

    println("Here is your book ${greenbook.title} wriiten by ${greenbook.author} in ${greenbook.year}")
     */

//Sets,Map,getOrPut ------------------------------------------------------------------------------------
    /*
    val allBooks = setOf("Macbeth", "A Midsummer Night's Dream","Hamlet")

    val lib = mapOf("WS" to allBooks)

    //when working with collections check if you need a value before handling what you want to a function
    println(lib.any{it.value.contains("Hamlet")})

    val moreBooks = mutableMapOf("Edgar Allan Poe" to "The Raven" )

    moreBooks.getOrPut("Jules Verne"){"The Mysterious Island"}

    moreBooks.getOrPut("Edgar Allan Poe"){"The Black Cat"}

    println(moreBooks)

     */

    val b = Book("This book", "THis author", 2020, 250)

    var pep = Puppy()

    while (b.pages>0)
    {
        pep.playWithBook(b)
        println("${b.pages}")
    }


}