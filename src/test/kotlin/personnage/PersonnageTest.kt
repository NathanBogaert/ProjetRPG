package personnage

import domain.model.personnage.Guerrier
import domain.model.personnage.Personnage
import org.junit.jupiter.api.Test

class PersonnageTest {
    private val personnage = Personnage()

    @Test
    fun `Lorsque le joueur affiche le récapitulatif du personnage, le récapitulatif affiche les bonnes informations`() {
        // Given
        personnage.nomDuPersonnage.nom = "Nathan"
        personnage.typeDuPersonnage.classe = Guerrier()
        val recapitulatifAttendu = """
            Nom: Nathan
            Statistiques physiques:
            Pts de vie: 150
            Force: 15
            Defense: 12
            Agilité: 8
            Endurance: 10
            Statistiques magiques:
            Pts de mana: 50
            Intelligence: 5
            Résistance magiques: 6
            Chance: 5
            Esprit: 4
        """.trimIndent()
        // When
        val recapitulatif = personnage.afficherRecapitulatif()
        // Then
        assert(recapitulatifAttendu == recapitulatif)
    }
}