package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Intelligence(private var intelligence: Int = 0) {
    fun afficherIntelligence(): String {
        return intelligence.toString()
    }
}