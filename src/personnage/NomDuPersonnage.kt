package personnage

class NomDuPersonnage {
    private var nom: String = ""

    fun ajouterNom() {
        do {
            println("Entrez le nom de votre personnage :")
            nom = readln()
        } while (!nomValide())
    }

    private fun nomValide(): Boolean {
        if (nom.length in 6..12) {
            return true
        }
        println("Le nom de votre personnage doit être compris entre 6 et 12 caractères.")
        return false
    }

    fun afficherNom(): String {
        return "Nom : $nom"
    }
}