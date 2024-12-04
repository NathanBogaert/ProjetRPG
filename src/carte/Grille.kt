package carte

class Grille {
    private val ligne = 5
    private val colonne = 5
    private val grille = List(ligne) { List(colonne) { Case(murPresent = true) } }
    private var positionCaseActuelle = intArrayOf(0, 0)

    fun verifierPresenceMur(positionGrilleX: Int, positionGrilleY: Int, maxPositionGrilleX: Int, maxPositionGrilleY: Int ) {
        when {
            positionGrilleX == 0 && positionGrilleY == 0 -> SupprimerMurGrilleCoinHautGauche().supprimerMursDeLaGrille(grille)
            positionGrilleX == maxPositionGrilleX && positionGrilleY == maxPositionGrilleY -> SupprimerMurGrilleCoinBasDroit().supprimerMursDeLaGrille(grille)
            positionGrilleX == 0 && positionGrilleY == maxPositionGrilleY -> SupprimerMurGrilleCoinHautDroit().supprimerMursDeLaGrille(grille)
            positionGrilleX == maxPositionGrilleX && positionGrilleY == 0 -> SupprimerMurGrilleCoinBasGauche().supprimerMursDeLaGrille(grille)
            positionGrilleX == 0 -> SupprimerMurGrilleBordHaut().supprimerMursDeLaGrille(grille)
            positionGrilleY == 0 -> SupprimerMurGrilleBordGauche().supprimerMursDeLaGrille(grille)
            positionGrilleX == maxPositionGrilleX -> SupprimerMurGrilleBordBas().supprimerMursDeLaGrille(grille)
            positionGrilleY == maxPositionGrilleY -> SupprimerMurGrilleBordDroit().supprimerMursDeLaGrille(grille)
            else -> SupprimerMurGrilleCentre().supprimerMursDeLaGrille(grille)
        }
        println("""Grille: posX=$positionGrilleX, posY=$positionGrilleY
            |Mur Nord: ${grille[0][2].murPresent}
            |Mur Ouest: ${grille[2][0].murPresent}
            |Mur Est: ${grille[2][4].murPresent}
            |Mur Sud: ${grille[4][2].murPresent}
        """.trimMargin())
    }
}