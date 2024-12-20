package personnage

import kotlinx.serialization.Serializable

@Serializable
data class Statistiques (
    val statistiquesPhysiques: StatistiquesPhysiques,
    val statistiquesMagiques: StatistiquesMagiques
)