package personnage

import kotlinx.serialization.Serializable

@Serializable
class NomDuPersonnage {
    lateinit var nom: String

    private fun ajouterNom(nom: String) {
        this.nom = nom
    }

    fun nomValide(nom: String): Boolean {
        if (nom.length in 6..12) {
            ajouterNom(nom)
            return true
        }
        println("Le nom de votre personnage doit être compris entre 6 et 12 caractères.")
        return false
    }
}