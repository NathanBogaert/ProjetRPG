package personnage.domain

data class Statistiques (
    private var pointsDeVie: Int = 0,
    private var pointsDeMana: Int = 0,
    private val statistiquesPhysiques: StatistiquesPhysiques = StatistiquesPhysiques(),
    private val statistiquesMagiques: StatistiquesMagiques = StatistiquesMagiques()
) {
    fun afficherStatistiques(): String {
        return "Points de vie: $pointsDeVie\nPoints de mana: $pointsDeMana\n${statistiquesPhysiques.afficherStatistiquesPhysiques()}\n${statistiquesMagiques.afficherStatistiquesMagiques()}"
    }
}