package sauvegarde

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class Sauvegarde: SauvegardeDuJeu {
    private val fichierSauvegardeJeu = File("sauvegardeJeu.json")

    override fun sauvegarderLeJeu(donneesSauvegarde: DonneesSauvegarde) {
        val json = Json { allowStructuredMapKeys = true }
        val donneesSerializer = json.encodeToString(donneesSauvegarde)
        fichierSauvegardeJeu.writeText(donneesSerializer)

        println("Sauvegarde effectuée.")
    }

    override fun chargerLeJeu(): DonneesSauvegarde {
        val json = Json { allowStructuredMapKeys = true }
        return json.decodeFromString<DonneesSauvegarde>(fichierSauvegardeJeu.readText())
    }

    override fun verifierPresenceFichier(): Boolean {
        if (fichierSauvegardeJeu.exists()) {
            return true
        }
        println("Aucune sauvegarde trouvée.")
        return false
    }
}