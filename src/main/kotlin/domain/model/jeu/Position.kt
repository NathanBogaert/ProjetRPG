package domain.model.jeu

import kotlinx.serialization.Serializable

@Serializable
data class Position(var x: Int, var y: Int) {
    fun mouvement(direction: Direction) {
        when (direction) {
            Direction.NORD -> y--
            Direction.SUD -> y++
            Direction.EST -> x++
            Direction.OUEST -> x--
        }
    }
}
