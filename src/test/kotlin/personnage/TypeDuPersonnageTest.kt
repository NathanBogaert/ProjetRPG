package personnage

import org.junit.jupiter.api.Test

class TypeDuPersonnageTest {
    private var typeDuPersonnage = TypeDuPersonnage()

    @Test
    fun typeValide() {
        typeDuPersonnage.typeString = "1"
        val expected = true
        assert(expected == typeDuPersonnage.verifierType())
    }

    @Test
    fun typeNonValide() {
        typeDuPersonnage.typeString = "0"
        val expected = false
        assert(expected == typeDuPersonnage.verifierType())
    }
}