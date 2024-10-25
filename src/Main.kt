import java.util.*

// Sujet: https://github.com/remihamy1/ProjetRPG/tree/main

fun main() {
    //val personnage = Personnage()
    val donjon = Donjon()

    lancementDuJeu(donjon, Personnage())
}

fun lancementDuJeu(donjon: Donjon, Personnage: Personnage) {
    var personnagePosition = intArrayOf(0, 0)
    var sortirDuJeu = false
    var deplacementVoulu: String
    var deplacementValide: Boolean
    var salleActuelle: Salle
    var porteNordDispo: Boolean
    var porteSudDispo: Boolean
    var porteOuestDispo: Boolean
    var porteEstDispo: Boolean
    var contientMonstre: Boolean
    var contientCoffre: Boolean
    var prochainDeplacement : IntArray
    while (!sortirDuJeu) {
        salleActuelle = donjon.donjon[personnagePosition[0]][personnagePosition[1]]
        porteNordDispo = salleActuelle.porteNordDispo
        porteSudDispo = salleActuelle.porteSudDispo
        porteEstDispo = salleActuelle.porteEstDispo
        porteOuestDispo = salleActuelle.porteOuestDispo
        deplacementValide = false
        while (!deplacementValide && !sortirDuJeu) {
            println("Vous êtes à la position (${personnagePosition[0]},${personnagePosition[1]}) dans quelle position voulez-vous allez (N, S, O, E) ? ou appuyez sur Q pour quitter.")
            deplacementVoulu = readln()
            when (deplacementVoulu.uppercase(Locale.getDefault())) {
                "N" -> {
                    if (porteNordDispo) {
                        prochainDeplacement = intArrayOf(personnagePosition[0] - 1, personnagePosition[1])
                        contientMonstre = donjon.donjon[prochainDeplacement[0]][prochainDeplacement[1]].contientMonstre
                        if (contientMonstre) {
                            println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
                        }
                        personnagePosition = prochainDeplacement
                        deplacementValide = true
                        println("Vous êtes maintenant en position (${personnagePosition[0]},${personnagePosition[1]}).")
                    } else {
                        println("Vous ne pouvez pas aller au Nord.")
                    }
                }
                "S" -> {
                    if (porteSudDispo) {
                        prochainDeplacement = intArrayOf(personnagePosition[0] + 1, personnagePosition[1])
                        contientMonstre = donjon.donjon[prochainDeplacement[0]][prochainDeplacement[1]].contientMonstre
                        if (contientMonstre) {
                            println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
                        }
                        personnagePosition = prochainDeplacement
                        deplacementValide = true
                        println("Vous êtes maintenant en position (${personnagePosition[0]},${personnagePosition[1]}).")
                    } else {
                        println("Vous ne pouvez pas aller au Sud.")
                    }
                }
                "O" -> {
                    if (porteOuestDispo) {
                        prochainDeplacement = intArrayOf(personnagePosition[0], personnagePosition[1] - 1)
                        contientMonstre = donjon.donjon[prochainDeplacement[0]][prochainDeplacement[1]].contientMonstre
                        if (contientMonstre) {
                            println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
                        }
                        personnagePosition = prochainDeplacement
                        deplacementValide = true
                        println("Vous êtes maintenant en position (${personnagePosition[0]},${personnagePosition[1]}).")
                    } else {
                        println("Vous ne pouvez pas aller à l'ouest.")
                    }
                }
                "E" -> {
                    if (porteEstDispo) {
                        prochainDeplacement = intArrayOf(personnagePosition[0], personnagePosition[1] + 1)
                        contientMonstre = donjon.donjon[prochainDeplacement[0]][prochainDeplacement[1]].contientMonstre
                        if (contientMonstre) {
                            println("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
                        }
                        personnagePosition = prochainDeplacement
                        deplacementValide = true
                        println("Vous êtes maintenant en position (${personnagePosition[0]},${personnagePosition[1]}).")
                    } else {
                        println("Vous ne pouvez pas aller à l'est.")
                    }
                }
                "Q" -> sortirDuJeu = true
                else -> {
                    deplacementValide = false
                    println("Veuillez saisir un déplacement valide : N (Nord), S (Sud), O (Ouest), E (Est).")
                }
            }
        }
    }
}