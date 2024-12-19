package personnage

import kotlinx.serialization.Serializable

@Serializable
data class StatistiquesMagiques (
    private var pointsDeMana: Int,
    private var intelligence: Int,
    private var resistanceMagiques: Int,
    private var chance: Int,
    private var esprit: Int
) {
    fun afficherStatistiquesMagiques(): String {
        return """Statistiques Magiques:
            |Pts de mana: $pointsDeMana
            |Intelligence: $intelligence
            |Résistance magiques: $resistanceMagiques
            |Chance: $chance
            |Esprit: $esprit
        """.trimMargin()
    }
}