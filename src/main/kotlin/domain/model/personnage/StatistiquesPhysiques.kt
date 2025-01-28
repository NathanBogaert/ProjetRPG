package domain.model.personnage

import domain.model.personnage.statistiques.*
import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesPhysiques (
    val pointsDeVie: PointsDeVie,
    val force: Force,
    val defense: Defense,
    val agilite: Agilite,
    val endurance: Endurance
)