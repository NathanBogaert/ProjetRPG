package personnage

import domain.model.personnage.TypeDuPersonnage
import org.junit.jupiter.api.Test

class TypeDuPersonnageTest {
    private var typeDuPersonnage = TypeDuPersonnage()

    @Test
    fun estValide() {
        val type = "1"
        val expected = true
        val resultat = typeDuPersonnage.estValide(type)
        assert(expected == resultat)
    }

    @Test
    fun typeNonValide() {
        val type = "0"
        val expected = false
        val resultat = typeDuPersonnage.estValide(type)
        assert(expected == resultat)
    }
}