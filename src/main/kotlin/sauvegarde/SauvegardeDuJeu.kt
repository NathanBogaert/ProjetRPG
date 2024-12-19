package sauvegarde

interface SauvegardeDuJeu {
    fun sauvegarderLeJeu(donneesSauvegarde: DonneesSauvegarde)
    fun chargerLeJeu(): DonneesSauvegarde
    fun verifierPresenceFichier(): Boolean
}