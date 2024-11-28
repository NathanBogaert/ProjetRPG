package donjon

import java.util.*

class DeplacementDuPersonnage {
    private var personnagePosition: IntArray = intArrayOf(0, 0)
    private lateinit var salleActuelle: Salle
    private lateinit var prochaineSalle : Salle
    private var deplacementVoulu: String = ""

    fun seDeplacer(donjon: Donjon) {
        salleActuelle = donjon.obtenirSalleActuelle(personnagePosition)
        println("Vous êtes à la position (${personnagePosition[0]},${personnagePosition[1]}) dans quelle position voulez-vous allez (N, S, O, E) ? ou appuyez sur Q pour quitter.")
        deplacementVoulu = readln()
        when (deplacementVoulu.uppercase(Locale.getDefault())) {
            "N" -> verifierDeplacement(donjon = donjon, prochaineSallePositionX = -1, prochaineSallePositionY = 0, porteDisponible = salleActuelle.obtenirPorteNord())
            "S" -> verifierDeplacement(donjon = donjon, prochaineSallePositionX = 1, prochaineSallePositionY = 0, porteDisponible = salleActuelle.obtenirPorteSud())
            "O" -> verifierDeplacement(donjon = donjon, prochaineSallePositionX = 0, prochaineSallePositionY = -1, porteDisponible = salleActuelle.obtenirPorteOuest())
            "E" -> verifierDeplacement(donjon = donjon, prochaineSallePositionX = 0, prochaineSallePositionY = 1, porteDisponible = salleActuelle.obtenirPorteEst())
            else -> println("Veuillez saisir un déplacement valide : N (Nord), S (Sud), O (Ouest), E (Est).")
        }
    }

    private fun verifierDeplacement(donjon: Donjon, prochaineSallePositionX: Int, prochaineSallePositionY: Int, porteDisponible: Boolean): Boolean {
        if (porteDisponible) {
            prochaineSalle = donjon.obtenirSalleActuelle(intArrayOf(personnagePosition[0] + prochaineSallePositionX, personnagePosition[1] + prochaineSallePositionY))
            verifierPresenceMonstre(prochaineSalle)
            personnagePosition = intArrayOf(personnagePosition[0] + prochaineSallePositionX, personnagePosition[1] + prochaineSallePositionY)
            println("Vous êtes maintenant en position (${personnagePosition[0]},${personnagePosition[1]}).")
            return true
        }
        println("Vous ne pouvez pas aller dans cette direction.")
        return false
    }

    private fun verifierPresenceMonstre(prochaineSalle: Salle) {
        if (prochaineSalle.obtenirMonstre()) {
            println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
        }
    }
}