package domain.model.personnage

import domain.model.personnage.statistiques.*
import kotlinx.serialization.Serializable

@Serializable
class Voleur: Classe {
    override val statistiques = Statistiques(
        statistiquesPhysiques = StatistiquesPhysiques(
            pointsDeVie = PointsDeVie(110),
            force = Force(10),
            defense = Defense(8),
            agilite = Agilite(15),
            endurance = Endurance(7)
        ),
        statistiquesMagiques = StatistiquesMagiques(
            pointsDeMana = PointsDeMana(70),
            intelligence = Intelligence(7),
            resistanceMagique = ResistanceMagique(7),
            chance = Chance(12),
            esprit = Esprit(6)
        )
    )
}