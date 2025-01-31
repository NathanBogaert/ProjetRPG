package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Defense(private val defense: Int = 0) {
    fun afficherDefense(): String {
        return defense.toString()
    }
}