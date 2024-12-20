package personnage

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Voleur: StatistiquesDuType {
    @Transient
    private lateinit var statistiques: Statistiques

    override fun ajouterStatistiques() {
        statistiques = Statistiques(
            statistiquesPhysiques = StatistiquesPhysiques(
                pointsDeVie = 110,
                force = 10,
                defense = 8,
                agilite = 15,
                endurance = 7
            ),
            statistiquesMagiques = StatistiquesMagiques(
                pointsDeMana = 70,
                intelligence = 7,
                resistanceMagiques = 7,
                chance = 12,
                esprit = 6
            )
        )
    }

    override fun afficherStatistiques(): String {
        return statistiques.afficherStatistiques()
    }
}