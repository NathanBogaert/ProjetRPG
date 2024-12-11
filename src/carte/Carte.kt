package carte

import grille.Grille

class Carte {
    private val ligne = 10
    private val colonne = 10
    val carte = List(ligne) { posX -> List(colonne) { posY -> Grille().verifierPresenceMur(posX, posY, ligne-1, colonne-1) } }
    lateinit var positionCarte: PositionCarte
}