package personnage

class Personnage {
    var nom: NomDuPersonnage = NomDuPersonnage()
    var type: TypeDuPersonnage = TypeDuPersonnage()

    fun afficherRecapitulatif(): String {
        val statistiquesPhysiques = type.type.statistiques.statistiquesPhysiques
        val statistiquesMagiques = type.type.statistiques.statistiquesMagiques
        return """
            Nom: ${nom.nom}
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