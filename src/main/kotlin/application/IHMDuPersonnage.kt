package application

import domain.model.personnage.Personnage
import java.util.*

class IHMDuPersonnage(
    private val ihm: IHM
) {
    fun creationDuNom(personnage: Personnage) {
        var nomDuPersonnage: String
        do {
            ihm.afficher("Entrez le nom de votre personnage :")
            nomDuPersonnage = readln()
        } while (!personnage.nomDuPersonnage.estValide(nomDuPersonnage))
    }
    
    fun creationDuType(personnage: Personnage) {
        var typeDuPersonnage: String
        do {
            ihm.afficher(
                """
                Choisissez le type de votre personnage :
                1. Guerrier
                2. Mage
                3. Voleur
            """.trimIndent()
            )
            typeDuPersonnage = readln()
        } while (!personnage.typeDuPersonnage.estValide(typeDuPersonnage))
    }
    
    fun afficherRecapitulatif(personnage: Personnage) {
        var doitAfficherRecapitulatif: String
        do {
            ihm.afficher("Voulez-vous afficher le récapitulatif du personnage (O/N) ?")
            doitAfficherRecapitulatif = readln()
            when (doitAfficherRecapitulatif.uppercase(Locale.getDefault())) {
                "O" -> {
                    ihm.afficher(recapitulatif(personnage))
                    break
                }
                "N" -> break
                else -> ihm.afficher("Choix invalide, veuillez entrez O ou N")
            }
        } while (doitAfficherRecapitulatif != "O" && doitAfficherRecapitulatif != "N")
    }

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