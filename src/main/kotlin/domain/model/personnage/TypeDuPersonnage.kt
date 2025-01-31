package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
class TypeDuPersonnage(
    private val typeDuPersonnageFactory: TypeDuPersonnageFactory
) {
    lateinit var classe: Classe

    private fun creerType(classe: Classe) {
        this.classe = classe
    }

    fun estValide(type: String): Boolean {
        val classeChoisie = typeDuPersonnageFactory.choixDuType(type)
        if (classeChoisie != null) {
            creerType(classeChoisie)
            return true
        }
        println("Entrez 1, 2 ou 3 pour choisir le type de votre personnage.")
        return false
    }
}