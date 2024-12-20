package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
sealed interface Classe {
    val statistiques: Statistiques
}