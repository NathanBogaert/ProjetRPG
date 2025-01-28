package domain.model.personnage

import domain.model.personnage.statistiques.*
import kotlinx.serialization.Serializable

@Serializable
class Mage: Classe {
    override val statistiques = Statistiques(
        statistiquesPhysiques = StatistiquesPhysiques(
            pointsDeVie = PointsDeVie(90),
            force = Force(4),
            defense = Defense(5),
            agilite = Agilite(7),
            endurance = Endurance(5)
        ),
        statistiquesMagiques = StatistiquesMagiques(
            pointsDeMana = PointsDeMana(150),
            intelligence = Intelligence(15),
            resistanceMagique = ResistanceMagique(12),
            chance = Chance(6),
            esprit = Esprit(10)
        )
    )
}