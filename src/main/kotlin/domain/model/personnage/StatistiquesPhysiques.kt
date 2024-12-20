package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesPhysiques (
    val pointsDeVie: Int , // Créer un type pour chaque stats
    val force: Int,
    val defense: Int,
    val agilite: Int,
    val endurance: Int
)