class Personnage (
    private var nom: String = "",
    private var type: String = "",
    private var force: Int = 0,
    private var defense: Int = 0,
    private var sante: Int = 0,
    private var mana: Int = 0,
) {
    init {
        var nomValide = false
        var typeValide = false
        nom = ""
        type = ""
        while (!nomValide) {
            println("Entrez le nom de votre personnage :")
            nom = readln()
            if (nom.length in 6..12) {
                nomValide = true
            } else {
                println("Le nom de votre personnage doit être compris entre 6 et 12 caractères.")
            }
        }
        while (!typeValide) {
            println(
                """Choisissez le type de votre personnage (1, 2, 3) :
        1. Guerrier
        2. Mage
        3. Voleur
            """.trimIndent()
            )
            type = readln()
            when (type) {
                "1" -> {
                    type = "Guerrier"
                    force = 3
                    defense = 8
                    sante = 10
                    mana = 0
                    typeValide = true
                }
                "2" -> {
                    type = "Mage"
                    force = 5
                    defense = 3
                    sante = 5
                    mana = 8
                    typeValide = true
                }
                "3" -> {
                    type = "Voleur"
                    force = 9
                    defense = 2
                    sante = 4
                    mana = 0
                    typeValide = true
                }
                else -> println("Vous devez entrer 1, 2 ou 3 pour sélectionner le type de votre personnage.")
            }
        }
        println("""
            Nom: $nom
            Type: $type
            Force: $force
            Défense: $defense
            Santé: $sante
            Mana: $mana
        """.trimIndent())
    }
}