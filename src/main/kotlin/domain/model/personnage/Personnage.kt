package domain.model.personnage

class Personnage {
    var nomDuPersonnage: NomDuPersonnage = NomDuPersonnage()
    var typeDuPersonnage: TypeDuPersonnage = TypeDuPersonnage()

    // Mettre dans une classe IHM (faire une interface pour gérer chaque "type" de print, pour le personnage, les stats, etc)
    fun afficherRecapitulatif(): String {
        val statistiquesPhysiques = typeDuPersonnage.classe.statistiques.statistiquesPhysiques
        val statistiquesMagiques = typeDuPersonnage.classe.statistiques.statistiquesMagiques
        return """
            Nom: ${nomDuPersonnage.nom}
            Statistiques physiques:
            Pts de vie: ${statistiquesPhysiques.pointsDeVie}
            Force: ${statistiquesPhysiques.force}
            Defense: ${statistiquesPhysiques.defense}
            Agilité: ${statistiquesPhysiques.agilite}
            Endurance: ${statistiquesPhysiques.endurance}
            Statistiques magiques:
            Pts de mana: ${statistiquesMagiques.pointsDeMana}
            Intelligence: ${statistiquesMagiques.intelligence}
            Résistance magiques: ${statistiquesMagiques.resistanceMagiques}
            Chance: ${statistiquesMagiques.chance}
            Esprit: ${statistiquesMagiques.esprit}
        """.trimIndent()
    }
}