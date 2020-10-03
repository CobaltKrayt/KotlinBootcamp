package Spice

class Spice(var name:String,var spiciness:String = "mild") {

    var heat: Int = 0
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }

    init{
        println("${this.heat}")
        println("${this.name}")
        println("${this.spiciness}")
    }
}

fun makeSalt() = Spice("Salt")