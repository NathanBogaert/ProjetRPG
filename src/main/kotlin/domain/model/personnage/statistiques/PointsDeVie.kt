package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class PointsDeVie(private val pointsDeVie: Int = 0) {
    fun afficherPointsDeVie(): String {
        return pointsDeVie.toString()
    }
}