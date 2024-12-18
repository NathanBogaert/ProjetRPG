package personnage

data class StatistiquesPhysiques (
    private var pointsDeVie: Int ,
    private var force: Int,
    private var defense: Int,
    private var agilite: Int,
    private var endurance: Int
) {
    fun afficherStatistiquesPhysiques(): String {
        return """Statistiques physiques:
            |Pts de vie: $pointsDeVie
            |Force: $force
            |Defense: $defense
            |Agilite: $agilite
            |Endurance: $endurance
        """.trimMargin()
    }
}