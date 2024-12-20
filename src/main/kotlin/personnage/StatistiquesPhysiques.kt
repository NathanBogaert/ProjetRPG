package personnage

import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesPhysiques (
    val pointsDeVie: Int ,
    val force: Int,
    val defense: Int,
    val agilite: Int,
    val endurance: Int
)