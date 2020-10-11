package Books

class Book(var title: String, var author: String,var year: Int,var pages: Int) {

    fun getTA() = title to author

    fun getTAY() = Triple(title,author,year)

    //used this to implement top level constant MBN
    fun canBorrow(hasBooks: Int):Boolean{ if(hasBooks>= MBN) return false else return true }

    fun printUrl(){
        println("${Constants.BASE_URL?: BASE_URL}${title}.html")
    }

    init{
        printUrl()
    }

    //using this to make BASE_URL accesible to book without using the Constants object
    companion object{
        val BASE_URL = "http://www.turtlecarecompobj.net/"
    }

}

//Constant values under Constants object
object Constants{
    const val BASE_URL  = "http://www.turtlecare.net/"
}
