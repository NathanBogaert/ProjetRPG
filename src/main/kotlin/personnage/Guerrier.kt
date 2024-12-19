package personnage

import kotlinx.serialization.Serializable

@Serializable
class Guerrier: StatistiquesDuType {
    private lateinit var statistiques: Statistiques

    override fun ajouterStatistiques() {
        statistiques = Statistiques(
            statistiquesPhysiques = StatistiquesPhysiques(
                pointsDeVie = 150,
                force = 15,
                defense = 12,
                agilite = 8,
                endurance = 10
            ),
            statistiquesMagiques = StatistiquesMagiques(
                pointsDeMana = 50,
                intelligence = 5,
                resistanceMagiques = 6,
                chance = 5,
                esprit = 4
            )
        )
    }

    override fun afficherStatistiques(): String {
        return statistiques.afficherStatistiques()
    }
}