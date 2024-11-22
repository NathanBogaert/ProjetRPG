package jeu

import donjon.Donjon
import personnage.Personnage

class Jeu {
    private var sortirDuJeu: Boolean = false
    private val deplacementDuPersonnage: DeplacementDuPersonnage = DeplacementDuPersonnage()

    fun lancementDuJeu() {
        val personnage = Personnage()
        personnage.creerLePersonnage()
        personnage.afficherInfo()

        val donjon = Donjon()

        while (!sortirDuJeu) {
            deplacementDuPersonnage.seDeplacer(donjon)
        }
    }
}