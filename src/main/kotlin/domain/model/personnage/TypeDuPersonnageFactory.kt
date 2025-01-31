package domain.model.personnage

import kotlinx.serialization.Serializable

@Serializable
class TypeDuPersonnageFactory {
    fun choixDuType(choix: String): Classe? {
        return when (choix) {
            "1" -> Guerrier()
            "2" -> Mage()
            "3" -> Voleur()
            else -> null
        }
    }
}