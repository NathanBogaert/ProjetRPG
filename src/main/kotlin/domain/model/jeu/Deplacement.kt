package domain.model.jeu

class Deplacement(
    private val gestionDeplacement: GestionDeplacement
) {
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
            else -> println("Commande inconnue.")
        }
    }

    private fun deplacement(direction: Direction) {
        gestionDeplacement.deplacer(direction)
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
}