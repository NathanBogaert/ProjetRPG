package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Chance(private var chance: Int = 0) {
    fun afficherChance(): String {
        return chance.toString()
    }
}