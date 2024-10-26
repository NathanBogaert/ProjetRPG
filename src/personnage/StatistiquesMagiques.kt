package personnage

class StatistiquesMagiques {
    private var intelligence: Int = 0
    private var resistanceMagiques: Int = 0
    private var esprit: Int = 0

    fun initialiserStatistiquesMagiques(type: TypeDuPersonnage) {
        when (type.type()) {
            "Guerrier" -> {
                intelligence = 5
                resistanceMagiques = 6
                esprit = 4
            }
            "Mage" -> {
                intelligence = 15
                resistanceMagiques = 12
                esprit = 10
            }
            "Voleur" -> {
                intelligence = 7
                resistanceMagiques = 7
                esprit = 6
            }
        }
    }

    fun afficherStatistiquesMagiques(): String {
        return "Intelligence: $intelligence\nResistance magiques: $resistanceMagiques\nEsprit: $esprit"
    }
}