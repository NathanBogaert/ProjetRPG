package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Endurance(private var endurance: Int = 0) {
    fun afficherEndurance(): String {
        return endurance.toString()
    }
}