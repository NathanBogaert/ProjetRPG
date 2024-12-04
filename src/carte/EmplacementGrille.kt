package carte

data class EmplacementGrille (val x: Int, val y: Int)

object EmplacementsMur {
    val NORD = EmplacementGrille(0, 2)
    val OUEST = EmplacementGrille(2, 0)
    val EST = EmplacementGrille(2, 4)
    val SUD = EmplacementGrille(4, 2)
}