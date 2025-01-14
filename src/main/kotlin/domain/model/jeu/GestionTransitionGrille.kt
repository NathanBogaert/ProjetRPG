package domain.model.jeu

class GestionTransitionGrille(
    private val carte: Carte
) {
    fun calculerTransitionGrille(direction: Direction, positionActuelle: Position, grilleActuelle: Grille): Pair<Grille, Position>? {
        val positionGrilleActuelle = carte.grilles.entries.firstOrNull { it.value == grilleActuelle }?.key ?: return null
        val positionNouvelleGrille = positionGrilleActuelle.copy().apply { mouvement(direction) }
        val nouvelleGrille = carte.obtenirGrille(positionNouvelleGrille)

        if (nouvelleGrille != null) {
            val nouvellePosition = calculerNouvellePositionGrille(direction, nouvelleGrille, positionActuelle, grilleActuelle)
            if (nouvelleGrille.obtenirContenu(nouvellePosition) == Mur) {
                println("Un obstacle vous bloque le passage. Vous ne pouvez pas aller par là.")
                return null
            }
            println("Vous êtes passé à une nouvelle grille.")
            return Pair(nouvelleGrille, nouvellePosition)
        }
        return null
    }

    private fun calculerNouvellePositionGrille(
        direction: Direction,
        grille: Grille,
        positionActuelle: Position,
        grilleActuelle: Grille
    ) = when (direction) {
        Direction.NORD -> Position(positionActuelle.x, grille.hauteur - 1)
        Direction.SUD -> Position(positionActuelle.x, 0)
        Direction.OUEST -> Position(grilleActuelle.largeur - 1, positionActuelle.y)
        Direction.EST -> Position(0, positionActuelle.y)
    }
}