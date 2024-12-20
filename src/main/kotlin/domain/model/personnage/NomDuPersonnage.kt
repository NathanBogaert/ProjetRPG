package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
class NomDuPersonnage {
    lateinit var nom: String

    private fun creerNom(nom: String) {
        this.nom = nom
    }

    fun estValide(nom: String): Boolean {
        if (longueurValide(nom)) {
            creerNom(nom)
            return true
        }
        println("Le nom de votre personnage doit être compris entre 6 et 12 caractères.")
        return false
    }

    private fun longueurValide(nom: String) = nom.length in 6..12
}