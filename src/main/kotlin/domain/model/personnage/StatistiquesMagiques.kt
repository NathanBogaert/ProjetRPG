package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesMagiques (
    val pointsDeMana: Int, // Créer un type pour chaque stats
    val intelligence: Int,
    val resistanceMagiques: Int,
    val chance: Int,
    val esprit: Int
)