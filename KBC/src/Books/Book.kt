package Books

class Book(var title: String, var author: String,var year: Int) {

    fun getTA() = title to author

    fun getTAY() = Triple(title,author,year)
}