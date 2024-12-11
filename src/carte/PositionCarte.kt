package carte

class PositionCarte {
    var positionCarteActuelle = intArrayOf(0, 0)

    fun changerPosition(ajoutPosX: Int, ajoutPosY: Int) {
        positionCarteActuelle[0] += ajoutPosX
        positionCarteActuelle[1] += ajoutPosY
    }
}