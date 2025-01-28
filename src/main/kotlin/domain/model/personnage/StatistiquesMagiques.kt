package domain.model.personnage

import domain.model.personnage.statistiques.*
import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesMagiques (
    val pointsDeMana: PointsDeMana,
    val intelligence: Intelligence,
    val resistanceMagique: ResistanceMagique,
    val chance: Chance,
    val esprit: Esprit
)