package domain.port.serverside

import domain.model.sauvegarde.DonneesDeSauvegarde

interface SauvegardeDuJeu {
    fun sauvegarderLeJeu(donneesDeSauvegarde: DonneesDeSauvegarde)
    fun chargerLeJeu(): DonneesDeSauvegarde
    fun verifierPresenceSauvegarde(): Boolean
}