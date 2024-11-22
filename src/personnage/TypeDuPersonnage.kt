package personnage

class TypeDuPersonnage {
    lateinit var type: String

    fun selectionnerType() {
        do {
            println(
                """Choisissez le type de votre personnage (1, 2, 3) :
                    1. Guerrier
                    2. Mage
                    3. Voleur
                """.trimIndent()
            )
            type = readln()
        } while (!verifierType())
    }

    fun verifierType(): Boolean {
        if (type == "1") {
            type = "Guerrier"
            return true
        }
        if (type == "2") {
            type = "Mage"
            return true
        }
        if (type == "3") {
            type = "Voleur"
            return true
        }
        println("Vous devez entrer 1, 2 ou 3 pour sélectionner le type de votre personnage.")
        return false
    }

    fun type(): String {
        return type
    }

    fun afficherType():String {
        return "Type: $type"
    }
}