package domain.service

import application.IHMDuJeu
import domain.model.jeu.*

class DeplacementService(
    private val gestionTransitionGrille: GestionTransitionGrille,
    private var grilleActuelle: Grille,
    private var sauvegardeService: SauvegardeService,
    private var ihm: IHMDuJeu
): GestionDeplacement {
    var position = Position(1, 1)

    override fun deplacer(direction: Direction) {
        val nouvellePosition = position.copy().apply { mouvement(direction) }
        if (!grilleActuelle.positionValide(nouvellePosition)) {
            val transitionGrille = gestionTransitionGrille.calculerTransitionGrille(direction, position, grilleActuelle)
            if (transitionGrille != null) {
                changerGrille(transitionGrille)
            } else {
                ihm.afficherAtteinteBordDuMonde(direction)
            }
            return
        }

        when (grilleActuelle.obtenirContenu(nouvellePosition)) {
            Vide, null -> changerPosition(nouvellePosition)
            Mur -> ihm.afficherObstacleBloque()
            Monstre -> ihm.afficherMonstreBloque()
            Tresor -> {
                ihm.afficherTresorTrouve()
                changerPosition(nouvellePosition)
            }
        }

        sauvegardeService.sauvegarde(position, direction, grilleActuelle)
    }

    private fun changerPosition(nouvellePosition: Position) {
        position = nouvellePosition
        ihm.afficherNouvellePosition(position)
    }

    private fun changerGrille(transitionGrille: Pair<Grille, Position>) {
        grilleActuelle = transitionGrille.first
        changerPosition(transitionGrille.second)
    }
}