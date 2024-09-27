class Personnage (
    val nom: String,
    var type: String,
    var force: Int = 0,
    var defense: Int = 0,
    var sante: Int = 0,
    var mana: Int = 0,
) {
    init {
        if (type == "Guerrier") {
            force = 3
            defense = 8
            sante = 10
            mana = 0
        } else if (type == "Mage") {
            force = 5
            defense = 3
            sante = 5
            mana = 8
        } else if (type == "Voleur") {
            force = 9
            defense = 2
            sante = 4
            mana = 0
        }
    }
}