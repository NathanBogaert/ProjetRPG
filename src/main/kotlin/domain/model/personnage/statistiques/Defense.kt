package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Defense(private var defense: Int = 0) {
    fun afficherDefense(): String {
        return defense.toString()
    }
}