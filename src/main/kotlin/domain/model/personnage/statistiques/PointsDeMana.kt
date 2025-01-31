package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class PointsDeMana(private val pointsDeMana: Int = 0) {
    fun afficherPointsDeMana(): String {
        return pointsDeMana.toString()
    }
}