package grille

import carte.Case

interface PresenceMur {
    fun supprimerMursDeLaGrille(grille: List<List<Case>>)
}