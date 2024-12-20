package sauvegarde

import jeu.Carte
import jeu.Direction
import jeu.Position
import kotlinx.serialization.Serializable
import personnage.NomDuPersonnage
import personnage.TypeDuPersonnage

@Serializable
data class DonneesDeSauvegarde(
    val position: Position,
    val direction: Direction,
    val positionGrilleActuelle: Position,
    val carte: Carte,
    val nomDuPersonnage: NomDuPersonnage,
    val typeDuPersonnage: TypeDuPersonnage
)