package personnage

class Mage: StatistiquesDuType {
    lateinit var statistiques: Statistiques

    override fun ajouterStatistiques() {
        statistiques = Statistiques(
            statistiquesPhysiques = StatistiquesPhysiques(
                pointsDeVie = 90,
                force = 4,
                defense = 5,
                agilite = 7,
                endurance = 5
            ),
            statistiquesMagiques = StatistiquesMagiques(
                pointsDeMana = 150,
                intelligence = 15,
                resistanceMagiques = 12,
                chance = 6,
                esprit = 10
            )
        )
    }

    override fun afficherStatistiques(): String {
        return statistiques.afficherStatistiques()
    }
}