package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Esprit(private var esprit: Int = 0) {
    fun afficherEsprit(): String {
        return esprit.toString()
    }
}