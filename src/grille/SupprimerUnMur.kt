package grille

import carte.Case

class GestionnaireDesMurs: SuppressionMur {
    override fun supprimerUnMur(grille: List<List<Case>>, emplacement: EmplacementGrille) {
        grille[emplacement.x][emplacement.y].murPresent = false
    }
}