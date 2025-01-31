package personnage

import domain.model.personnage.TypeDuPersonnage
import domain.model.personnage.TypeDuPersonnageFactory
import org.junit.jupiter.api.Test

class TypeDuPersonnageTest {
    private val typeDuPersonnageFactory = TypeDuPersonnageFactory()
    private var typeDuPersonnage = TypeDuPersonnage(typeDuPersonnageFactory)

    @Test
    fun `Lorsque le joueur entre un type valide, le type est validé`() {
        // Given
        val type = "1"
        val validationAttendu = true
        // When
        val typeDuPersonnageValide = typeDuPersonnage.estValide(type)
        // Then
        assert(validationAttendu == typeDuPersonnageValide)
    }

    @Test
    fun `Lorsque le joueur entre un type non valide, le type n'est pas validé`() {
        // Given
        val type = "0"
        val validationAttendu = false
        // When
        val typeDuPersonnageValide = typeDuPersonnage.estValide(type)
        // Then
        assert(validationAttendu == typeDuPersonnageValide)
    }
}