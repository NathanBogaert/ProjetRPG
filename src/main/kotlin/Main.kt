import jeu.Carte
import jeu.Deplacement
import jeu.GestionTransitionGrille
import jeu.Position
import java.util.*

// https://github.com/remihamy1/ProjetRPG/tree/main

fun main() {
//    val personnage = Personnage()
//    personnage.nom.ajouterNom()
//    personnage.type.choixDuType()
//    personnage.afficherInfo()

    val carte = Carte()
    carte.creerCarte()

    val deplacementUtilisateur = carte.obtenirGrille(Position(0, 0))?.let { Deplacement(it, GestionTransitionGrille(carte)) }
    if (deplacementUtilisateur != null) {
        println("Vous êtes en position ${deplacementUtilisateur.position.x}, ${deplacementUtilisateur.position.y}.")
    }

    while (true) {
        println("Entrez un deplacement (N,S,E,O,A,G,D) ou Q pour quitter :")
        val choixDeplacement = readln()
        if (choixDeplacement.uppercase(Locale.getDefault()) == "Q") break
        deplacementUtilisateur?.commandeDeplacement(choixDeplacement.uppercase(Locale.getDefault()))
    }
}