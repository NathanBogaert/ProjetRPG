package personnage

import domain.model.personnage.NomDuPersonnage
import org.junit.jupiter.api.Test

class NomDuPersonnageTest {
    private val nomDuPersonnage = NomDuPersonnage()

    @Test
    fun `Lorsque le joueur entre un nom valide, le nom est créer`() {
        // Given
        val validationAttendu = true
        val nomAttendu = "nathan"
        // When
        val nomDuPersonnageValide = nomDuPersonnage.estValide(nomAttendu)
        val nomDuPersonnage = nomDuPersonnage.nom
        // Then
        assert(validationAttendu == nomDuPersonnageValide)
        assert(nomAttendu == nomDuPersonnage)
    }

    @Test
    fun `Lorsque le joueur entre un nom trop court, le nom n'est pas validé`() {
        // Given
        val nom = ""
        val validationAttendu = false
        // When
        val nomDuPersonnageValide = nomDuPersonnage.estValide(nom)
        // Then
        assert(validationAttendu == nomDuPersonnageValide)
    }

    @Test
    fun `Lorsque le joueur entre un nom trop long, le nom n'est pas validé`() {
        // Given
        val nom = "aaaaaaaaaaaaa"
        val validationAttendu = false
        // When
        val nomDuPersonnageValide = nomDuPersonnage.estValide(nom)
        // Then
        assert(validationAttendu == nomDuPersonnageValide)
    }
}