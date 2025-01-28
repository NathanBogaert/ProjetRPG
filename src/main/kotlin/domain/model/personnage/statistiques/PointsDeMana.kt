package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class PointsDeMana(private var pointsDeMana: Int = 0) {
    fun afficherPointsDeMana(): String {
        return pointsDeMana.toString()
    }
}