package personnage

class StatistiquesPhysiques {
    private var force: Int = 0
    private var defense: Int = 0
    private var agilite: Int = 0
    private var chance: Int = 0
    private var endurance: Int = 0

    fun initialiserStatistiquesPhysiques(type: TypeDuPersonnage) {
        when (type.type()) {
            "Guerrier" -> {
                force = 15
                defense = 12
                agilite = 8
                chance = 5
                endurance = 10
            }
            "Mage" -> {
                force = 4
                defense = 5
                agilite = 7
                chance = 6
                endurance = 5
            }
            "Voleur" -> {
                force = 10
                defense = 8
                agilite = 15
                chance = 12
                endurance = 7
            }
        }
    }

    fun afficherStatistiquesPhysiques():String {
        return "Force: $force\nDefense: $defense\nAgilite: $agilite\nChance: $chance\nEndurance: $endurance"
    }
}