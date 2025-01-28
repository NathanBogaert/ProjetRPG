package domain.model.jeu

import kotlinx.serialization.Serializable

@Serializable
class Carte {
    var largeur = 10
    var hauteur = 10
    val grilles: MutableMap<Position, Grille> = mutableMapOf()

    fun creerCarte() {
        for (x in 0 until largeur) {
            for (y in 0 until hauteur) {
                val positionCarte = Position(x, y)
                val nouvelleGrille = Grille()

                nouvelleGrille.creerGrille()
                grilles[positionCarte] = nouvelleGrille
            }
        }
    }

    fun obtenirGrille(position: Position): Grille? {
        return grilles[position]
    }
}