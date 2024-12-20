package domain.model.jeu

import kotlinx.serialization.Serializable
import kotlin.random.Random

@Serializable
class Grille {
    val largeur = 5
    val hauteur = 5
    private val cases: MutableMap<Position, ContenuCase> = mutableMapOf()
    private val maxMurs = 2

    fun creerGrille() {
        var mursPresents = 0

        for (x in 0 until largeur) {
            for (y in 0 until hauteur) {
                val position = Position(x, y)
                if (mursPresents < maxMurs && Random.nextBoolean()) {
                    ajouterContenuCase(position, Mur)
                    mursPresents++
                } else {
                    ajouterContenuCase(position, Vide)
                }
            }
        }
    }

    fun ajouterContenuCase(position: Position, contenuCase: ContenuCase) {
        cases[position] = contenuCase
    }

    fun obtenirContenu(position: Position): ContenuCase? {
        return cases[position]
    }

    fun positionValide(position: Position): Boolean {
        return position.x in 0 until largeur && position.y in 0 until hauteur
    }
}