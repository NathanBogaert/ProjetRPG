package domain.model.personnage

import domain.model.personnage.statistiques.*
import kotlinx.serialization.Serializable

@Serializable
class Guerrier: Classe {
    override val statistiques = Statistiques(
        statistiquesPhysiques = StatistiquesPhysiques(
            pointsDeVie = PointsDeVie(150),
            force = Force(15),
            defense = Defense(12),
            agilite = Agilite(8),
            endurance = Endurance(10)
        ),
        statistiquesMagiques = StatistiquesMagiques(
            pointsDeMana = PointsDeMana(50),
            intelligence = Intelligence(5),
            resistanceMagique = ResistanceMagique(6),
            chance = Chance(5),
            esprit = Esprit(4)
        )
    )
}