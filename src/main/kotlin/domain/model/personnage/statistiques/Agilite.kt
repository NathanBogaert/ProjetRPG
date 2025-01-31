package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Agilite(private val agilite: Int = 0) {
    fun afficherAgilite(): String {
        return agilite.toString()
    }
}