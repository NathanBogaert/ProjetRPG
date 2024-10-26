package personnage

class Statistiques {
    private var pointsDeVie: Int = 0
    private var pointsDeMana: Int = 0
    private val statistiquesPhysiques: StatistiquesPhysiques = StatistiquesPhysiques()
    private val statistiquesMagiques: StatistiquesMagiques = StatistiquesMagiques()

    fun initiliserStatistiques(type: TypeDuPersonnage) {
        when (type.type()) {
            "Guerrier" -> {
                pointsDeVie = 150
                pointsDeMana = 50
                statistiquesPhysiques.initialiserStatistiquesPhysiques(type)
                statistiquesMagiques.initialiserStatistiquesMagiques(type)
            }
            "Mage" -> {
                pointsDeVie = 90
                pointsDeMana = 150
                statistiquesPhysiques.initialiserStatistiquesPhysiques(type)
                statistiquesMagiques.initialiserStatistiquesMagiques(type)
            }
            "Voleur" -> {
                pointsDeVie = 110
                pointsDeMana = 70
                statistiquesPhysiques.initialiserStatistiquesPhysiques(type)
                statistiquesMagiques.initialiserStatistiquesMagiques(type)
            }
        }
    }

    fun afficherStatistiques(): String {
        return "Points de vie: $pointsDeVie\nPoints de mana: $pointsDeMana\n${statistiquesPhysiques.afficherStatistiquesPhysiques()}\n${statistiquesMagiques.afficherStatistiquesMagiques()}"
    }
}