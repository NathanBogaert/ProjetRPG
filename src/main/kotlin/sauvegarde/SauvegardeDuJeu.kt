package sauvegarde

interface SauvegardeDuJeu {
    fun sauvegarderLeJeu(donneesDeSauvegarde: DonneesDeSauvegarde)
    fun chargerLeJeu(): DonneesDeSauvegarde
    fun verifierPresenceFichier(): Boolean
}