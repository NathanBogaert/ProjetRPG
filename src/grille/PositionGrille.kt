package grille

class PositionGrille(private val grille: Grille) {
    var positionGrilleActuelle = intArrayOf(0, 0)

    fun changerPosition(ajoutPosX: Int, ajoutPosY: Int) {
        if (ajoutPosX in 0 .. grille.ligne) {
            positionGrilleActuelle[0] += ajoutPosX
        }
        if (ajoutPosY in 0 .. grille.colonne) {
            positionGrilleActuelle[1] += ajoutPosY
        }
    }
}