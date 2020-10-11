package Books

fun Book.weight() = pages*1.5

fun Book.tornPages(torn: Int) = if(pages >= torn)pages -= torn else pages = 0
