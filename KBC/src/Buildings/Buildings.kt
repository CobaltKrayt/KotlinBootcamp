package Buildings

//open class so we can make subclasses
open class BaseBuildingMaterial()
{
    //open var so we can ovveride this proprety
    open var numberNeeded = 1
}
//subclass/subtype/material
class Wood: BaseBuildingMaterial()
{
    //overriding the property
    override var numberNeeded = 4
}

class Brick: BaseBuildingMaterial()
{
    override var numberNeeded = 8
}

//a generic class that uses tha BBM class as type; specify that by adding the name of the class after the :
//generic types narrow the amount of options so that the code is clear to read
class Building<out T: BaseBuildingMaterial>(val BM: T)
{
    var baseMaterialsNeeded = 100
    var actualMaterialsNeeded = baseMaterialsNeeded * BM.numberNeeded

    fun build()
    {
        //instance::class.simpleName is how you get the name of the class
        println("$actualMaterialsNeeded ${BM::class.simpleName}")
    }

}
//generic functions can take a type T of varying class type as argument and use it
fun <T: BaseBuildingMaterial>isSmallBuilding(block: Building<T>)
{
     if(block.actualMaterialsNeeded<500) println("small building")
        else  println("large building")
}

fun main(args: Array<String>)
{
    //could have also written Building(wood()).build()
    var b1 = Building(Wood())

    b1.build()
    Building(Brick()).build()

    isSmallBuilding(b1)
    isSmallBuilding(Building(Brick()))

}
