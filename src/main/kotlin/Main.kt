import jeu.Carte
import jeu.Deplacement
import jeu.GestionTransitionGrille
import jeu.Position
import personnage.Personnage
import sauvegarde.Sauvegarde
import java.util.*

// https://github.com/remihamy1/ProjetRPG/tree/main

fun main() {
    var choixMenu: String
    val sauvegardeJeu = Sauvegarde()
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
            choixMenu == "1" -> {
                personnage.nom.ajouterNom()
                personnage.type.choixDuType()
                personnage.afficherInfo()
                carte.creerCarte()
                val deplacementUtilisateur = carte.obtenirGrille(Position(0, 0))?.let { Deplacement(it, GestionTransitionGrille(carte), sauvegardeJeu, personnage) }

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
                personnage.nom = donneesSauvegardeJeu.nomDuPersonnage
                personnage.type = donneesSauvegardeJeu.typeDuPersonnage
                personnage.type.type.ajouterStatistiques()
                carte = donneesSauvegardeJeu.carte
                val deplacementUtilisateur = carte.obtenirGrille(donneesSauvegardeJeu.positionGrilleActuelle)?.let { Deplacement(it, GestionTransitionGrille(carte), sauvegardeJeu, personnage) }

                if (deplacementUtilisateur != null) {
                    deplacementUtilisateur.position = donneesSauvegardeJeu.position
                    deplacementUtilisateur.direction = donneesSauvegardeJeu.direction
                    println("${personnage.afficherInfo()}")
                    println("Vous êtes en position ${deplacementUtilisateur.position.x}, ${deplacementUtilisateur.position.y} sur la grille en position ${deplacementUtilisateur.gestionTransitionGrille.carte.grilles.entries.first { it.value == deplacementUtilisateur.grilleActuelle }.key.x}, ${deplacementUtilisateur.gestionTransitionGrille.carte.grilles.entries.first { it.value == deplacementUtilisateur.grilleActuelle }.key.y}.")

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