package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
class TypeDuPersonnage {
    lateinit var classe: Classe
    private val typesDisponibles = mapOf(
        "1" to Guerrier(),
        "2" to Mage(),
        "3" to Voleur()
    )

    private fun creerType(classe: Classe) {
        this.classe = classe
    }

    fun estValide(type: String): Boolean {
        if (typesDisponibles.containsKey(type)) {
            typesDisponibles[type]?.let {
                creerType(it)
            }
            return true
        }
        println("Entrez 1, 2 ou 3 pour choisir le type de votre personnage.")
        return false
    }
}