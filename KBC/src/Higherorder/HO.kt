package Higherorder

import kotlin.math.absoluteValue

//another example of enums
enum class Directions()
{
    NORTH, SOUTH, EAST,WEST,START,END
}
class Game()
{
    var path= mutableListOf(Directions.START)
    var mtrxmap = Location()

    //simple example of how lambdas work
    var north = {path.add(Directions.NORTH)}
    var south = {path.add(Directions.SOUTH)}
    var east = {path.add(Directions.EAST)}
    var west = {path.add(Directions.WEST)}

    //the ; is quite important
    var end = {path.add(Directions.END); println("Game Over $path");path.clear(); false}

    fun move(where: ()-> Boolean)//returns unit :)
    {
        where.invoke()
    }

    fun makeMove(nls: String?)
    {
        var test = nls

        if(test.equals("north")) {
            mtrxmap.updateLocation(Directions.NORTH)
            move(north)
        } else if(test.equals("south")) {
            mtrxmap.updateLocation(Directions.SOUTH)
            move(south)
        } else if(test.equals("east")) {
            mtrxmap.updateLocation(Directions.EAST)
            move(east)
        } else if(test.equals("west")) {
            mtrxmap.updateLocation(Directions.WEST)
            move(west)
        }
    }
}
class Location(val width:Int = 4,val height:Int = 4)
{
    //this is how you can make matrixes in kotlin
    var map = Array(width){ arrayOfNulls<String>(height)}

    var currentLocation = Pair(0,0)

    fun updateLocation(directions: Directions)
    {
        if(directions.equals(Directions.NORTH)){
            currentLocation = Pair(currentLocation.first,(currentLocation.second+1).rem(height))
        }
        else if(directions.equals(Directions.SOUTH)) {
            currentLocation=Pair(currentLocation.first,(currentLocation.second-1).absoluteValue.rem(height))
        } else if(directions.equals(Directions.EAST)) {
            currentLocation=Pair((currentLocation.first+1).rem(width),currentLocation.second)
        } else if(directions.equals(Directions.WEST)) {
            currentLocation=Pair((currentLocation.first-1).absoluteValue.rem(width),currentLocation.second)
        }
    }

    fun getDescription ():String? {
        return map[currentLocation.first.rem(width)][currentLocation.second.rem(height)]
    }

    init {
        map[0][0] = "You are at the start of your journey. [n / e]"
        map[0][1] = "The road stretches before you. It promises beauty and adventure. [ n / s / e]"
        map[0][2] = "The road still stretches before you. It rains and the water forms puddles. [ n / s / e]"
        map[0][3] = "It is getting much colder and you wish you had a wool coat. [ s / e]"

        map[1][0] = "The narrow path stretches before you. You are glad you are on foot. [ n / e /w]"
        map[1][1] = "It is getting warmer. You smell moss, and marmot scat. You are stung by a mosquito. [ n / s / e / w]"
        map[1][2] = "You decide to sit on your backside and slide down a vast snowfield. [ n / s / e /w]"
        map[1][3] = "You have climbed to the top of a snowy mountain and are enjoying the view. [ w / s / e]"

        map[2][0] = "You cross an old stone bridge. Your hear the murmuring of water. And another grumbling sound. [ n / e / w]"
        map[2][1] = "A bridge troll appears. It swings a club and demands gold. You give them all your coins. [ n / s / e  /w]"
        map[2][2] = "It is getting cooler. A dense fog rolls in. You can hear strange voices. [ n / s / e / w]"
        map[2][3] = "The foothills promise a strenuous journey. You thread your way around gigantic boulders. [ s / e / w ]"

        map[3][0] = "Your journey continues. A fox runs across the path with a chicken in its mouth.[ n / e ]"
        map[3][1] = "In the distance, you see a house. You almost bump into a farmer with a large shotgun. They pay you no heed. [ n / s / w ]"
        map[3][2] = "It is getting hot, and dry, and very, very quiet. You think of water and wish you had brought a canteen.[ n / s / w ]"
        map[3][3] = "You have reached the infinite desert. There is nothing here but sand dunes. You are bitten by a sand flea.[ s / w ] "
    }


}

fun main(args: Array<String>)
{
    var g = Game()
    var g2 = Game()

    //dont forget what you actually want to print; in this case im talking about the mutablelist of directons not the instance itself lol
    println(g.path)

    //remember to think about lambdas as functions no matter their form because thats what they are
    g.north()
    g.east()
    g.south()
    g.west()
    g.west()
    g.end()

   // println(g.path)

   // val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)

   // print(numbers.divisibleBy { it.rem(3) })

    while(true)
    {
        println("Enter a direction: n/s/e/w:")
        g2.makeMove(readLine())
        println(g2.mtrxmap.getDescription())

        /*if(readLine() == "stop")
        {
            println(g2.path)
            break
        } else g2.makeMove(readLine())
        */
    }
}

//harder to grasp
//this is an extension on LIST as we want to modify it,
//with a lambda function named DIVISIBLEBY which takes in a function/lambda named block on (Int) -> Int and returns a list
fun List<Int>.divisibleBy(block: (Int) -> Int):List<Int>
{
    val result = mutableListOf<Int>()
    //travels through THIS list
    for (item in this)
    {
        //block takes the it function in our case
        if(block(item) == 0)
        {
            result.add(item)
        }
    }
    return result
}
//lambdas are objects
//inlines stop the creation of objects for every call of a lambda