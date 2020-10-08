package SpiceOld

class simpleSpice {
    var spF: String = "mild"
    var name: String = "curry"
    val heat: Int
        get() {
            if (spF == "mild") return 5
            else return 0
        }

}