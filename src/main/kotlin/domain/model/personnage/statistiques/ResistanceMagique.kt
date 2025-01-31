package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class ResistanceMagique(private val resistanceMagique: Int = 0) {
    fun afficherResistanceMagique(): String {
        return resistanceMagique.toString()
    }
}