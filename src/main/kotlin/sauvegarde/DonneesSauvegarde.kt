package sauvegarde

import jeu.Carte
import jeu.Direction
import jeu.Position
import kotlinx.serialization.Serializable
import personnage.Personnage

@Serializable
data class DonneesSauvegarde(
    val position: Position,
    val direction: Direction,
    val positionGrilleActuelle: Position,
    val carte: Carte,
)
