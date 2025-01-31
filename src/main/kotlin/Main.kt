import application.AffichageSimple
import application.IHMDuJeu
import application.IHMDuPersonnage
import domain.model.jeu.Carte
import domain.model.jeu.Deplacement
import domain.model.jeu.GestionTransitionGrille
import domain.model.jeu.Position
import domain.model.personnage.Personnage
import domain.service.DeplacementService
import domain.service.SauvegardeService
import infrastructure.SauvegardeFichier

// https://github.com/remihamy1/ProjetRPG/tree/main

fun main() {
    var quitterJeu = false
    var choixMenu: String
    val sauvegardeJeu = SauvegardeFichier()
    val personnage = Personnage()
    var carte = Carte()
    val affichageSimple = AffichageSimple()
    val ihmDuJeu = IHMDuJeu(affichageSimple)
    val ihmDuPersonnage = IHMDuPersonnage(affichageSimple)

    while (!quitterJeu) {
        choixMenu = ihmDuJeu.afficherMenuPrincipal()
        when {
            nouvellePartie(choixMenu) -> {
                ihmDuPersonnage.creationDuNom(personnage)
                ihmDuPersonnage.creationDuType(personnage)
                ihmDuPersonnage.afficherRecapitulatif(personnage)

                carte.creerCarte()
                val (deplacementService, deplacementUtilisateur) = creationDuJeu(
                    sauvegardeJeu,
                    personnage,
                    carte,
                    Position(0, 0),
                    ihmDuJeu
                )

                if (deplacementUtilisateur != null && deplacementService != null) {
                    ihmDuJeu.afficherPosition(deplacementService)
                    ihmDuJeu.lancerJeu(deplacementUtilisateur)
                }
            }
            chargerPartie(choixMenu, sauvegardeJeu) -> {
                val donneesSauvegardeJeu = sauvegardeJeu.chargerLeJeu()
                personnage.nomDuPersonnage = donneesSauvegardeJeu.nomDuPersonnage
                personnage.typeDuPersonnage = donneesSauvegardeJeu.typeDuPersonnage
                carte = donneesSauvegardeJeu.carte
                val (deplacementService, deplacementUtilisateur) = creationDuJeu(
                    sauvegardeJeu,
                    personnage,
                    carte,
                    donneesSauvegardeJeu.positionGrilleActuelle,
                    ihmDuJeu
                )
                
                if (deplacementUtilisateur != null && deplacementService != null) {
                    deplacementService.position = donneesSauvegardeJeu.position
                    deplacementUtilisateur.direction = donneesSauvegardeJeu.direction
                    ihmDuPersonnage.afficherRecapitulatif(personnage)
                    ihmDuJeu.afficherPosition(deplacementService)
                    ihmDuJeu.lancerJeu(deplacementUtilisateur)
                }
            }
            quitterLeJeu(choixMenu) -> quitterJeu = true
            autresCommandes(choixMenu) -> {
                ihmDuJeu.afficherCommandeInconnue()
            }
        }
    }
}

private fun creationDuJeu(
    sauvegardeJeu: SauvegardeFichier,
    personnage: Personnage,
    carte: Carte,
    positionGrille: Position,
    ihm: IHMDuJeu
): Pair<DeplacementService?, Deplacement?> {
    val sauvegardeService = SauvegardeService(sauvegardeJeu, personnage, carte)
    val deplacementService = carte.obtenirGrille(positionGrille)?.let { DeplacementService(GestionTransitionGrille(carte), it, sauvegardeService, ihm)
    }
    val deplacementUtilisateur = deplacementService?.let { Deplacement(it) }
    return Pair(deplacementService, deplacementUtilisateur)
}

private fun nouvellePartie(choixMenu: String) = choixMenu == "1"

private fun chargerPartie(choixMenu: String, sauvegardeJeu: SauvegardeFichier) = 
    choixMenu == "2" && sauvegardeJeu.verifierPresenceSauvegarde()

private fun quitterLeJeu(choixMenu: String) = choixMenu == "3"

private fun autresCommandes(choixMenu: String) = choixMenu != "2"