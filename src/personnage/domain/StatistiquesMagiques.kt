package personnage.domain

class StatistiquesMagiques {
    private var intelligence: Int = 0
    private var resistanceMagiques: Int = 0
    private var esprit: Int = 0

    fun afficherStatistiquesMagiques(): String {
        return "Intelligence: $intelligence\nResistance magiques: $resistanceMagiques\nEsprit: $esprit"
    }
}