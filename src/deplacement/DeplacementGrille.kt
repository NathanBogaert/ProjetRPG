package deplacement

import grille.Grille

class DeplacementGrille(private val grille: Grille) {
    private var deplacement: String = ""

    fun obtenirDeplacement() {
        do {
            println("Dans quelle direction veux-tu aller ? (N,S,O,E)")
            deplacement = readln()
        } while (true)
    }

    fun miseAJourPosition(ajoutDeplacement: String) {
        when (ajoutDeplacement) {
            "N" -> grille.positionGrille.changerPosition(0, 1)
            "S" -> grille.positionGrille.changerPosition(0, -1)
            "O" -> grille.positionGrille.changerPosition(-1, 0)
            "E" -> grille.positionGrille.changerPosition(1, 0)
            else -> println("Erreur dans le déplacement")
        }
    }
}