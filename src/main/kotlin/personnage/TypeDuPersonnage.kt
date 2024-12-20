package personnage

import kotlinx.serialization.Serializable

@Serializable
class TypeDuPersonnage {
    lateinit var typeString: String
    lateinit var type: StatistiquesDuType
    private val typesDisponibles = mapOf(
        "1" to Guerrier(),
        "2" to Mage(),
        "3" to Voleur()
    )

    fun choixDuType() {
        do {
            println(
                """Choisissez le type de votre personnage (1, 2, 3) :
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
        println("Écrivez 1, 2 ou 3 pour choisir le type de votre personnage.")
        return false
    }

    fun afficherStatistiques(): String {
        return type.afficherStatistiques()
    }
}