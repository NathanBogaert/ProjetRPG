package domain.service

import domain.model.jeu.*

class DeplacementService(
    private val gestionTransitionGrille: GestionTransitionGrille,
    private var grilleActuelle: Grille,
    private var sauvegardeService: SauvegardeService
): GestionDeplacement {
    var position = Position(1, 1)

    override fun deplacer(direction: Direction) {
        val nouvellePosition = position.copy().apply { mouvement(direction) }
        if (!grilleActuelle.positionValide(nouvellePosition)) {
            val transitionGrille = gestionTransitionGrille.calculerTransitionGrille(direction, position, grilleActuelle)
            if (transitionGrille != null) {
                changerGrille(transitionGrille)
            } else {
                println("Vous avez atteint le bord du monde. Vous ne pouvez aller plus au ${direction.name.lowercase()}.")
            }
            return
        }

        when (grilleActuelle.obtenirContenu(nouvellePosition)) {
            Vide, null -> changerPosition(nouvellePosition)
            Mur -> println("Un obstacle vous bloque le passage. Vous ne pouvez pas aller par là.")
            Monstre -> println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
            Tresor -> {
                println("Vous avez trouvé un trésor !")
                changerPosition(nouvellePosition)
            }
        }

        sauvegardeService.sauvegarde(position, direction, grilleActuelle)
    }

    private fun changerPosition(nouvellePosition: Position) {
        position = nouvellePosition
        println("Vous êtes maintenant en position ${nouvellePosition.x}, ${nouvellePosition.y}.")
    }

    private fun changerGrille(transitionGrille: Pair<Grille, Position>) {
        grilleActuelle = transitionGrille.first
        changerPosition(transitionGrille.second)
    }
}