package carte

interface SuppressionMur {
    fun supprimerUnMur(grille: List<List<Case>>, emplacement: EmplacementGrille)
}