package domain.model.jeu

import domain.model.personnage.Personnage
import domain.model.sauvegarde.DonneesDeSauvegarde
import domain.port.serverside.SauvegardeDuJeu

class Deplacement(
    var grilleActuelle: Grille,
    val gestionTransitionGrille: GestionTransitionGrille,
    private val sauvegardeDuJeu: SauvegardeDuJeu,
    private val personnage: Personnage
) {
    var position = Position(1, 1)
    var direction = Direction.NORD

    fun commandeDeplacement(commande: String) {
        when (commande) {
            "N" -> deplacement(Direction.NORD)
            "S" -> deplacement(Direction.SUD)
            "O" -> deplacement(Direction.OUEST)
            "E" -> deplacement(Direction.EST)
            "A" -> avancer()
            "G" -> tournerGauche()
            "D" -> tournerDroite()
            "SAVE" -> sauvegarderJeu()
            else -> println("Commande inconnue.")
        }
    }

    private fun deplacement(direction: Direction) {
        val nouvellePosition = position.copy().apply { mouvement(direction) }

        if (!grilleActuelle.positionValide(nouvellePosition)) {
            if (!gestionTransitionGrille.changerGrille(direction, this)) {
                println("Vous avez atteint le bord du monde. Vous ne pouvez aller plus au ${direction.name.lowercase()}.")
            }
            return
        }

        when (grilleActuelle.obtenirContenu(nouvellePosition)) {
            Vide, null -> {
                changerPosition(nouvellePosition)
            }
            Mur -> {
                println("Un obstacle vous bloque le passage. Vous ne pouvez pas aller par là.")
            }
            Monstre -> {
                println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
            }
            Tresor -> {
                println("Vous avez trouvé un trésor !")
                changerPosition(nouvellePosition)
            }
        }
    }

    private fun changerPosition(nouvellePosition: Position) {
        position = nouvellePosition
        println("Vous êtes maintenant en position ${position.x}, ${position.y}.")
    }

    private fun avancer() {
        deplacement(direction)
    }

    private fun tournerGauche() {
        direction = when (direction) {
            Direction.NORD -> Direction.OUEST
            Direction.OUEST -> Direction.SUD
            Direction.SUD -> Direction.EST
            Direction.EST -> Direction.NORD
        }
        println("Vous faites maintenant face à $direction")
    }

    private fun tournerDroite() {
        direction = when (direction) {
            Direction.NORD -> Direction.EST
            Direction.OUEST -> Direction.NORD
            Direction.SUD -> Direction.OUEST
            Direction.EST -> Direction.SUD
        }
        println("Vous faites maintenant face à $direction")
    }

    // A partir d'ici il faut tout sortie de déplacement (créer un service)
    fun mettreAJourGrilleEtPosition(nouvelleGrille: Grille, nouvellePosition: Position) {
        grilleActuelle = nouvelleGrille
        position = nouvellePosition
    }

    private fun sauvegarderJeu() {
        val donneesDeSauvegarde = DonneesDeSauvegarde(
            position,
            direction,
            gestionTransitionGrille.carte.grilles.entries.first { it.value == grilleActuelle }.key,
            gestionTransitionGrille.carte,
            personnage.nomDuPersonnage,
            personnage.typeDuPersonnage
        )
        sauvegardeDuJeu.sauvegarderLeJeu(donneesDeSauvegarde)
    }
}