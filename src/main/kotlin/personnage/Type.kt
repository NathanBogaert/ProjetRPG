package personnage

import kotlinx.serialization.Serializable

@Serializable
sealed interface Type {
    val statistiques: Statistiques
}