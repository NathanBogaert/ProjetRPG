package grille

import carte.Case

interface SuppressionMur {
    fun supprimerUnMur(grille: List<List<Case>>, emplacement: EmplacementGrille)
}