import domain.model.jeu.Carte
import domain.model.jeu.Deplacement
import domain.model.jeu.GestionTransitionGrille
import domain.model.jeu.Position
import domain.model.personnage.Personnage
import infrastructure.SauvegardeFichier
import java.util.*

// https://github.com/remihamy1/ProjetRPG/tree/main

// Gérer les print dans une class IHM
// Mettre dans des fonctions tous ce qui est possible dans ce main

fun main() {
    var choixMenu: String
    val sauvegardeJeu = SauvegardeFichier()
    val personnage = Personnage()
    var carte = Carte()

    while (true) {
        println("""
            1. Nouvelle partie
            2. Charge partie
            3. Quitter
        """.trimIndent())

        choixMenu = readln()

        when {
            nouvellePartie(choixMenu) -> {
                var nomDuPersonnage: String
                do {
                    println("Entrez le nom de votre personnage :")
                    nomDuPersonnage = readln()
                } while (!personnage.nomDuPersonnage.estValide(nomDuPersonnage))

                var typeDuPersonnage: String
                do {
                    println("""
                        Choisissez le type de votre personnage :
                        1. Guerrier
                        2. Mage
                        3. Voleur
                    """.trimIndent())
                    typeDuPersonnage = readln()
                } while (!personnage.typeDuPersonnage.estValide(typeDuPersonnage))

                var afficherInfo: String
                do {
                    println("Voulez-vous afficher le récapitulatif du personnage (O/N) ?")
                    afficherInfo = readln()
                    when (afficherInfo.uppercase(Locale.getDefault())) {
                        "O" -> {
                            println(personnage.afficherRecapitulatif())
                            break
                        }
                        "N" -> break
                        else -> println("Choix invalide, veuillez entrez O ou N")
                    }
                } while (afficherInfo != "O" && afficherInfo != "N")

                carte.creerCarte()
                val deplacementUtilisateur = carte.obtenirGrille(Position(0, 0))?.let { Deplacement(it,
                    GestionTransitionGrille(carte), sauvegardeJeu, personnage) }

                if (deplacementUtilisateur != null) {
                    println("Vous êtes en position ${deplacementUtilisateur.position.x}, ${deplacementUtilisateur.position.y}.")

                    while (true) {
                        println("Entrez un deplacement (N,S,E,O,A,G,D) ou SAVE pour sauvegarder ou Q pour quitter :")
                        val choixDeplacement = readln()
                        if (choixDeplacement.uppercase(Locale.getDefault()) == "Q") break
                        deplacementUtilisateur.commandeDeplacement(choixDeplacement.uppercase(Locale.getDefault()))
                    }
                }
            }
            choixMenu == "2" && sauvegardeJeu.verifierPresenceFichier() -> {
                val donneesSauvegardeJeu = sauvegardeJeu.chargerLeJeu()
                personnage.nomDuPersonnage = donneesSauvegardeJeu.nomDuPersonnage
                personnage.typeDuPersonnage = donneesSauvegardeJeu.typeDuPersonnage
                personnage.typeDuPersonnage.classe
                carte = donneesSauvegardeJeu.carte
                val deplacementUtilisateur = carte.obtenirGrille(donneesSauvegardeJeu.positionGrilleActuelle)?.let { Deplacement(it,
                    GestionTransitionGrille(carte), sauvegardeJeu, personnage) }

                if (deplacementUtilisateur != null) {
                    deplacementUtilisateur.position = donneesSauvegardeJeu.position
                    deplacementUtilisateur.direction = donneesSauvegardeJeu.direction
                    println(personnage.afficherRecapitulatif())
                    val positionCarte = deplacementUtilisateur.gestionTransitionGrille.carte.grilles.entries.first { it.value == deplacementUtilisateur.grilleActuelle }.key
                    println("""Vous êtes en position ${deplacementUtilisateur.position.x}, ${deplacementUtilisateur.position.y} sur la grille en position ${positionCarte.x}, ${positionCarte.y}.""")

                    while (true) {
                        println("Entrez un deplacement (N,S,E,O,A,G,D) ou SAVE pour sauvegarder ou Q pour quitter :")
                        val choixDeplacement = readln()
                        if (choixDeplacement.uppercase(Locale.getDefault()) == "Q") break
                        deplacementUtilisateur.commandeDeplacement(choixDeplacement.uppercase(Locale.getDefault()))
                    }
                }
            }
            choixMenu == "3" -> break
            choixMenu != "2" -> {
                println("Commande inconnue, taper 1 pour débuter une nouvelle partie ou 2 pour charger la derniere sauvegarde")
            }
        }
    }
}

private fun nouvellePartie(choixMenu: String) = choixMenu == "1"