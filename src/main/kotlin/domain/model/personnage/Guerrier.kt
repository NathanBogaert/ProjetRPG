package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
class Guerrier: Classe {
    override val statistiques = Statistiques(
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