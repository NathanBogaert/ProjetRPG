package application

import domain.model.personnage.Personnage
import java.util.*

class AffichagePersonnageIHM(
    private val ihm: IHM,
    private val recapitulatifPersonnageIHM: RecapitulatifPersonnageIHM
) {
    fun afficherRecapitulatif(personnage: Personnage) {
        var doitAfficherRecapitulatif: String
        do {
            ihm.afficher("Voulez-vous afficher le récapitulatif du personnage (O/N) ?")
            doitAfficherRecapitulatif = readln()
            when (doitAfficherRecapitulatif.uppercase(Locale.getDefault())) {
                "O" -> {
                    ihm.afficher(recapitulatifPersonnageIHM.recapitulatif(personnage))
                    break
                }
                "N" -> break
                else -> ihm.afficher("Choix invalide, veuillez entrez O ou N")
            }
        } while (doitAfficherRecapitulatif != "O" && doitAfficherRecapitulatif != "N")
    }
}