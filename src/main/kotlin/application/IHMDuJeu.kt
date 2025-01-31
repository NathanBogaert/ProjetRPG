package application

import domain.model.jeu.Deplacement
import domain.model.jeu.Direction
import domain.model.jeu.Position
import domain.service.DeplacementService
import java.util.*

class IHMDuJeu(
    private val ihm: IHM
) {
    fun afficherMenuPrincipal(): String {
        ihm.afficher("""
            1. Nouvelle partie
            2. Charger partie
            3. Quitter
        """.trimIndent())
        return readln()
    }
    
    fun lancerJeu(deplacementUtilisateur: Deplacement) {
        while (true) {
            ihm.afficher("Entrez un deplacement (N,S,E,O,A,G,D) ou Q pour quitter :")
            val choixDeplacement = readln()
            if (choixDeplacement.uppercase(Locale.getDefault()) == "Q") break
            deplacementUtilisateur.commandeDeplacement(choixDeplacement.uppercase(Locale.getDefault()))
        }
    }
    
    fun afficherPosition(deplacementService: DeplacementService) {
        ihm.afficher("Vous êtes en position ${deplacementService.position.x}, ${deplacementService.position.y}.")
    }

    fun afficherCommandeInconnue() {
        ihm.afficher("Commande inconnue, taper 1 pour débuter une nouvelle partie ou 2 pour charger la derniere sauvegarde")
    }

    fun afficherAtteinteBordDuMonde(direction: Direction) {
        ihm.afficher("Vous avez atteint le bord du monde. Vous ne pouvez aller plus au ${direction.name.lowercase()}.")
    }

    fun afficherObstacleBloque() {
        ihm.afficher("Un obstacle vous bloque le passage. Vous ne pouvez pas aller par là.")
    }

    fun afficherMonstreBloque() {
        ihm.afficher("Un monstre bloque votre chemin ! Vous devez le vaincre pour avancer.")
    }

    fun afficherNouvellePosition(nouvellePosition: Position) {
        ihm.afficher("Vous êtes maintenant en position ${nouvellePosition.x}, ${nouvellePosition.y}.")
    }

    fun afficherTresorTrouve() {
        ihm.afficher("Vous avez trouvé un trésor !")
    }
}