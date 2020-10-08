package SpiceOld

import kotlin.random.Random

fun main()
{
    val spicesList = listOf(
            Spice("curry", "mild"),
            Spice("pepper", "medium"),
            Spice("cayenne", "spicy"),
            Spice("ginger", "mild"),
            Spice("red curry", "medium"),
            Spice("green curry", "mild"),
            Spice("hot pepper", "extremely spicy")
    )

    var x = 0

    var oneSpice = spicesList[Random.nextInt(spicesList.size)]
    
    var lessHotList = spicesList.filter{it.heat<=3}

    println("${oneSpice.name}, ${oneSpice.spiciness}")

    println("${lessHotList.map { it.name }}, ${lessHotList.map { it.heat }}")

    //var rollDice:(Int) -> Int = {x -> Random().nextInt(x*2)+2}
    //print(rollDice(x))

}