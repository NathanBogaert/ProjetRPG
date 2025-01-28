package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Agilite(private var agilite: Int = 0) {
    fun afficherAgilite(): String {
        return agilite.toString()
    }
}