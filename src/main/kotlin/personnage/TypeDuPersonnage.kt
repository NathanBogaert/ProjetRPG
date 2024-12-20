package personnage

import kotlinx.serialization.Serializable

@Serializable
class TypeDuPersonnage {
    lateinit var type: Type
    private val typesDisponibles = mapOf(
        "1" to Guerrier(),
        "2" to Mage(),
        "3" to Voleur()
    )

    private fun ajouterType(type: Type) {
        this.type = type
    }

    fun typeValide(type: String): Boolean {
        if (typesDisponibles.containsKey(type)) {
            typesDisponibles[type]?.let { ajouterType(it) }
            return true
        }
        println("Entrez 1, 2 ou 3 pour choisir le type de votre personnage.")
        return false
    }
}