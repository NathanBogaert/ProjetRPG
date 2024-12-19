package personnage

import kotlinx.serialization.Serializable

@Serializable
data class Statistiques (
    private val statistiquesPhysiques: StatistiquesPhysiques,
    private val statistiquesMagiques: StatistiquesMagiques
) {
    fun afficherStatistiques(): String {
        return """${statistiquesPhysiques.afficherStatistiquesPhysiques()}
            |${statistiquesMagiques.afficherStatistiquesMagiques()}
        """.trimMargin()
    }
}