fun main()
{
    var a = readLine()!!.split(' ').map { it.toInt() }
    var b = readLine()!!.split(' ').map { it.toInt() }

    when{
        a.size == b.size -> 1
        else -> return println("baboule nus egale")
    }

    val n = a.size;

    var ok: Boolean

    for (i in 0..n-1)
    {
        ok = false
        for( j in 0..n-1)
        {
            if (a[i]?:0 and (b[j]?:0)!=0)
            {
                ok = true;
                break;
            }
        }
        if (!ok) {
            print("false")
            return
        }
    }

    print("true")
}