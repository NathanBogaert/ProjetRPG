package domain.service

import domain.model.jeu.Carte
import domain.model.jeu.Direction
import domain.model.jeu.Grille
import domain.model.jeu.Position
import domain.model.personnage.Personnage
import domain.model.sauvegarde.DonneesDeSauvegarde
import domain.port.serverside.SauvegardeDuJeu

class SauvegardeService(
    private val sauvegardeDuJeu: SauvegardeDuJeu,
    private val personnage: Personnage,
    private val carte: Carte
) {
    fun sauvegarde(position: Position, direction: Direction, grilleActuelle: Grille) {
        val donneesDeSauvegarde = DonneesDeSauvegarde(
            position,
            direction,
            carte.grilles.entries.first { it.value == grilleActuelle }.key,
            carte,
            personnage.nomDuPersonnage,
            personnage.typeDuPersonnage
        )
        sauvegardeDuJeu.sauvegarderLeJeu(donneesDeSauvegarde)
    }
}