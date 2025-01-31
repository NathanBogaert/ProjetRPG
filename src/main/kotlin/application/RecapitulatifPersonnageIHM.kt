package application

import domain.model.personnage.Personnage

class RecapitulatifPersonnageIHM {
    fun recapitulatif(personnage: Personnage): String {
        val statistiquesPhysiques = personnage.typeDuPersonnage.classe.statistiques.statistiquesPhysiques
        val statistiquesMagiques = personnage.typeDuPersonnage.classe.statistiques.statistiquesMagiques
        return """
            Nom: ${personnage.nomDuPersonnage.nom}
            Statistiques physiques:
            Pts de vie: ${statistiquesPhysiques.pointsDeVie.afficherPointsDeVie()}
            Force: ${statistiquesPhysiques.force.afficherForce()}
            Defense: ${statistiquesPhysiques.defense.afficherDefense()}
            Agilité: ${statistiquesPhysiques.agilite.afficherAgilite()}
            Endurance: ${statistiquesPhysiques.endurance.afficherEndurance()}
            Statistiques magiques:
            Pts de mana: ${statistiquesMagiques.pointsDeMana.afficherPointsDeMana()}
            Intelligence: ${statistiquesMagiques.intelligence.afficherIntelligence()}
            Résistance magiques: ${statistiquesMagiques.resistanceMagique.afficherResistanceMagique()}
            Chance: ${statistiquesMagiques.chance.afficherChance()}
            Esprit: ${statistiquesMagiques.esprit.afficherEsprit()}
            """.trimIndent()
    }
}