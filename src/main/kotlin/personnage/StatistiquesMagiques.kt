package personnage

import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesMagiques (
    val pointsDeMana: Int,
    val intelligence: Int,
    val resistanceMagiques: Int,
    val chance: Int,
    val esprit: Int
)