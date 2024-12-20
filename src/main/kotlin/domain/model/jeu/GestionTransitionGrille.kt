package domain.model.jeu

class GestionTransitionGrille(val carte: Carte) {
    fun changerGrille(direction: Direction, deplacement: Deplacement): Boolean {
        val positionGrilleActuelle = carte.grilles.entries.firstOrNull { it.value == deplacement.grilleActuelle }?.key ?: return false
        val positionNouvelleGrille = positionGrilleActuelle.copy().apply { mouvement(direction) }
        val nouvelleGrille = carte.obtenirGrille(positionNouvelleGrille)

        if (nouvelleGrille != null) {
            val nouvellePosition = calculerNouvellePositionGrille(direction, nouvelleGrille, deplacement)
            if (nouvelleGrille.obtenirContenu(nouvellePosition) == Mur) {
                println("Un obstacle vous bloque le passage. Vous ne pouvez pas aller par là.")
                return false
            }
            deplacement.mettreAJourGrilleEtPosition(nouvelleGrille, nouvellePosition)
            println("Vous êtes passé à une nouvelle grille.")
            return true
        }
        return false
    }

    private fun calculerNouvellePositionGrille(direction: Direction, grille: Grille, deplacement: Deplacement) = when (direction) {
        Direction.NORD -> Position(deplacement.position.x, grille.hauteur - 1)
        Direction.SUD -> Position(deplacement.position.x, 0)
        Direction.OUEST -> Position(
            deplacement.grilleActuelle.largeur - 1,
            deplacement.position.y
        )
        Direction.EST -> Position(0, deplacement.position.y)
    }
}