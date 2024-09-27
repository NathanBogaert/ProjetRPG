fun main() {
    var nomValide = false
    var typeValide = false
    var nom = ""
    var type = ""
    while (nomValide == false) {
        println("Entrez le nom de votre personnage :")
        nom = readLine()!!
        if (nom.length >= 6 && nom.length <= 12) {
            nomValide = true
        } else {
            println("Le nom de votre personnage doit être compris entre 6 et 12 caractères.")
        }
    }
    while (typeValide == false) {
        println(
            """Choisissez le type de votre personnage (1, 2, 3) :
        1. Guerrier
        2. Mage
        3. Voleur
            """.trimIndent()
        )
        type = readLine()!!
        when (type) {
            "1" -> {
                type = "Guerrier"
                typeValide = true
            }
            "2" -> {
                type = "Mage"
                typeValide = true
            }
            "3" -> {
                type = "Voleur"
                typeValide = true
            }
            else -> println("Vous devez entrer 1, 2 ou 3 pour sélectionner le type de votre personnage")
        }
    }
    val personnage = Personnage(nom = nom, type = type)
    println("""
        Nom: ${personnage.nom}
        Type: ${personnage.type}
        Force: ${personnage.force}
        Défense: ${personnage.defense}
        Santé: ${personnage.sante}
        Mana: ${personnage.mana}
    """.trimIndent())
}