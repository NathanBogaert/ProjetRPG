package domain.model.personnage.statistiques

import kotlinx.serialization.Serializable

@Serializable
class Force(private var force: Int = 0) {
    fun afficherForce(): String {
        return force.toString()
    }
}