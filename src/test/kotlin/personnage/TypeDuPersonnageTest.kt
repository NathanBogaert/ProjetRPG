package personnage

import org.junit.jupiter.api.Test

class TypeDuPersonnageTest {
    private var typeDuPersonnage = TypeDuPersonnage()

    @Test
    fun typeValide() {
        val type = "1"
        val expected = true
        val resultat = typeDuPersonnage.typeValide(type)
        assert(expected == resultat)
    }

    @Test
    fun typeNonValide() {
        val type = "0"
        val expected = false
        val resultat = typeDuPersonnage.typeValide(type)
        assert(expected == resultat)
    }
}