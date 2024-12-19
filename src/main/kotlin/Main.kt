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
    var personnage = Personnage()
    var carte = Carte()

    while (true) {
        println("""2
            1. Nouvelle partie
            2. Charge partie
            3. Quitter
        """.trimIndent())

        choixMenu = readln()

        if (choixMenu == "1" || (choixMenu == "2" && sauvegardeJeu.verifierPresenceFichier()) || choixMenu == "3") break
        if (choixMenu != "2") println("Commande inconnue, taper 1 pour débuter une nouvelle partie ou 2 pour charger la derniere sauvegarde")
    }

    when (choixMenu) {
        "1" -> {
            personnage.nom.ajouterNom()
            personnage.type.choixDuType()
            personnage.afficherInfo()
            carte.creerCarte()
            val deplacementUtilisateur = carte.obtenirGrille(Position(0, 0))?.let { Deplacement(it, GestionTransitionGrille(carte), sauvegardeJeu) }

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

        "2" -> {
            val donneesSauvegardeJeu = sauvegardeJeu.chargerLeJeu()
            carte = donneesSauvegardeJeu.carte
            val deplacementUtilisateur = carte.obtenirGrille(donneesSauvegardeJeu.positionGrilleActuelle)?.let { Deplacement(it, GestionTransitionGrille(carte), sauvegardeJeu) }

            if (deplacementUtilisateur != null) {
                deplacementUtilisateur.position = donneesSauvegardeJeu.position
                deplacementUtilisateur.direction = donneesSauvegardeJeu.direction

                while (true) {
                    println("Entrez un deplacement (N,S,E,O,A,G,D) ou SAVE pour sauvegarder ou Q pour quitter :")
                    val choixDeplacement = readln()
                    if (choixDeplacement.uppercase(Locale.getDefault()) == "Q") break
                    deplacementUtilisateur.commandeDeplacement(choixDeplacement.uppercase(Locale.getDefault()))
                }
            }
        }

        else -> {
            return
        }
    }
}