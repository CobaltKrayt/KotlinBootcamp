package Spices

fun main()
{
    delegate()
}
abstract class Spice(var name:String,var spiciness:String = "mild",color: SpiceColor ): SpiceColor by color{

    //abstract allows us to further segmentate the class into subclasses with inheritance and all that

    //getters and setters for a variable
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

    //initializing with this? hmm
   /* init{
        println("${this.heat}")
        println("${this.name}")
        println("${this.spiciness}")
    }*/

    //need this to be acbstract so that it can be implemented in other classes
    abstract fun prepareSpice()
}

//a subclass inherits its properties. you must pass an arg for every property used
class Curry(name :String ,spiciness: String, color: SpiceColor = YellowSpiceColor):
        Spice(name, spiciness, color), Grinder //using the interface
{
    //ovr is actually implementing in this case
    override fun prepareSpice(){
        grind()
    }

}

//a mean via which any object can be ground
interface Grinder{
    fun grind():String = "Ground"
}

//a means via which any spice can pick its colour
//interfaces can also be used as types
interface SpiceColor{
    var color: String
    //var name: String
}

//a property that is linked with the spicecolor interface
object YellowSpiceColor: SpiceColor{
    override var color = "Yellow"
    //override var name = "Yellowish"
}

//dont see why this wouldnt be in main but it works i guess omegalul
fun delegate(){
    SpiceQuery()
    val unusualcurry = Curry("Weird Curry","mild")
    println("Colour of this curry is ${unusualcurry.color}")
}

data class SpiceContainer(var spice: Spice){
    var label = spice.name
}

fun SpiceQuery()
{
    var s1 = listOf(
            SpiceContainer(Curry("Cinnamon curry", "mild")),
            SpiceContainer(Curry("Pepper curry", "spicy")),
            SpiceContainer(Curry("Cayenne curry", "extremely spicy")))

    for(i in s1)println(i.label)

}