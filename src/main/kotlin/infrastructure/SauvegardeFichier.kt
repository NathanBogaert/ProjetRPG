package infrastructure

import domain.model.sauvegarde.DonneesDeSauvegarde
import domain.port.serverside.SauvegardeDuJeu
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

class SauvegardeFichier: SauvegardeDuJeu {
    private val fichierSauvegardeJeu = File("sauvegardeJeu.json")

    override fun sauvegarderLeJeu(donneesDeSauvegarde: DonneesDeSauvegarde) {
        val json = Json { allowStructuredMapKeys = true }
        val donneesSerializer = json.encodeToString(donneesDeSauvegarde)
        fichierSauvegardeJeu.writeText(donneesSerializer)
        println("Sauvegarde effectuée.")
    }

    override fun chargerLeJeu(): DonneesDeSauvegarde {
        val json = Json { allowStructuredMapKeys = true }
        return json.decodeFromString<DonneesDeSauvegarde>(fichierSauvegardeJeu.readText())
    }

    override fun verifierPresenceFichier(): Boolean {
        if (fichierSauvegardeJeu.exists()) {
            return true
        }
        println("Aucune sauvegarde trouvée.")
        return false
    }
}