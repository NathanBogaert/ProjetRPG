package carte

class Carte {
    private val ligne = 10
    private val colonne = 10
    private val carte = List(ligne) { posX -> List(colonne) { posY -> Grille().verifierPresenceMur(posX, posY, ligne-1, colonne-1) } }
    private var positionGrilleActuelle = intArrayOf(0, 0)

    fun changerDePosition(ajoutPosX: Int, ajoutPosY: Int) {
        positionGrilleActuelle[0] += ajoutPosX
        positionGrilleActuelle[1] += ajoutPosY
    }
}