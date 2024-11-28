package personnage.domain

class StatistiquesPhysiques {
    private var force: Int = 0
    private var defense: Int = 0
    private var agilite: Int = 0
    private var chance: Int = 0
    private var endurance: Int = 0

    fun afficherStatistiquesPhysiques():String {
        return "Force: $force\nDefense: $defense\nAgilite: $agilite\nChance: $chance\nEndurance: $endurance"
    }
}