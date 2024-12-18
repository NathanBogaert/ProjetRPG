package jeu

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