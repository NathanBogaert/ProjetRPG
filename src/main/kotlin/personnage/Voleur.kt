package personnage

import kotlinx.serialization.Serializable

@Serializable
class Voleur: Type {
    override val statistiques = Statistiques(
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