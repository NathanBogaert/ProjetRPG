package application

import domain.model.personnage.Personnage

class CreationPersonnageIHM(
    private val ihm: IHM
) {
    fun creationDuNom(personnage: Personnage) {
        var nomDuPersonnage: String
        do {
            ihm.afficher("Entrez le nom de votre personnage :")
            nomDuPersonnage = readln()
        } while (!personnage.nomDuPersonnage.estValide(nomDuPersonnage))
    }

    fun creationDuType(personnage: Personnage) {
        var typeDuPersonnage: String
        do {
            ihm.afficher(
                """
                Choisissez le type de votre personnage :
                1. Guerrier
                2. Mage
                3. Voleur
            """.trimIndent()
            )
            typeDuPersonnage = readln()
        } while (!personnage.typeDuPersonnage.estValide(typeDuPersonnage))
    }
}