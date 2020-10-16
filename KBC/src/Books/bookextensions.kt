package Books

//extensions are functions that add functionality to a class without modifying it. they have access to the public members of that class and they dont inherit
fun Book.weight() = pages*1.5

fun Book.tornPages(torn: Int) = if(pages >= torn)pages -= torn else pages = 0
