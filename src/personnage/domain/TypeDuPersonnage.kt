package personnage.domain

class TypeDuPersonnage {
    lateinit var typeString: String
    private lateinit var type: StatistiquesDuType
    private val typesDisponibles = mapOf(
        "1" to Guerrier(),
        "2" to Mage(),
        "3" to Voleur()
    )

    fun choixDuType() {
        do {
            println(
                """Choisis le type de ton personnage (1, 2, 3) :
                    1. Guerrier
                    2. Mage
                    3. Voleur
                """.trimIndent()
            )
            typeString = readln()
        } while (!verifierType())
        type = typesDisponibles[typeString]!!
        type.ajouterStatistiques()
    }

    fun verifierType(): Boolean {
        if (typesDisponibles.containsKey(typeString)) {
            return true
        }
        println("Écris 1, 2 ou 3 pour choisir le type de ton personnage.")
        return false
    }

    fun afficherStatistiques(): String {
        return type.afficherStatistiques()
    }
}