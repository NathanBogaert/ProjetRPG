package personnage

import kotlinx.serialization.Serializable

@Serializable
sealed interface StatistiquesDuType {
    fun ajouterStatistiques()
    fun afficherStatistiques(): String
}