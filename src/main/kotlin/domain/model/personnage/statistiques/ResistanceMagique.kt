package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class ResistanceMagique(private var resistanceMagique: Int = 0) {
    fun afficherResistanceMagique(): String {
        return resistanceMagique.toString()
    }
}