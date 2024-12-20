package domain.model.sauvegarde

import domain.model.jeu.Carte
import domain.model.jeu.Direction
import domain.model.jeu.Position
import domain.model.personnage.NomDuPersonnage
import domain.model.personnage.TypeDuPersonnage
import kotlinx.serialization.Serializable

@Serializable
data class DonneesDeSauvegarde(
    val position: Position,
    val direction: Direction,
    val positionGrilleActuelle: Position,
    val carte: Carte,
    val nomDuPersonnage: NomDuPersonnage,
    val typeDuPersonnage: TypeDuPersonnage
)