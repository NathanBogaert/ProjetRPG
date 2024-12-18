package jeu

class Deplacement(var grilleActuelle: Grille, private val gestionTransitionGrille: GestionTransitionGrille) {
    var position = Position(0, 0)
    var orientation = Direction.NORD

    fun commandeDeplacement(commande: String) {
        when (commande) {
            "N" -> deplacement(Direction.NORD)
            "S" -> deplacement(Direction.SUD)
            "O" -> deplacement(Direction.OUEST)
            "E" -> deplacement(Direction.EST)
            "A" -> avancer()
            "G" -> tournerGauche()
            "D" -> tournerDroite()
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
            Vide -> {
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
        deplacement(orientation)
    }

    private fun tournerGauche() {
        orientation = when (orientation) {
            Direction.NORD -> Direction.OUEST
            Direction.OUEST -> Direction.SUD
            Direction.SUD -> Direction.EST
            Direction.EST -> Direction.NORD
        }
        println("Vous faites maintenant face à $orientation")
    }

    private fun tournerDroite() {
        orientation = when (orientation) {
            Direction.NORD -> Direction.EST
            Direction.OUEST -> Direction.NORD
            Direction.SUD -> Direction.OUEST
            Direction.EST -> Direction.SUD
        }
        println("Vous faites maintenant face à $orientation")
    }

    fun mettreAJourGrilleEtPosition(nouvelleGrille: Grille, nouvellePosition: Position) {
        grilleActuelle = nouvelleGrille
        position = nouvellePosition
    }
}