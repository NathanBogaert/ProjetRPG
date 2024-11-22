package personnage

import org.junit.jupiter.api.Test

class TypeDuPersonnageTest {
    private var typeDuPersonnage = TypeDuPersonnage()

    @Test
    fun typeValide() {
        typeDuPersonnage.type = "1"
        val expected = true
        assert(expected == typeDuPersonnage.verifierType())
    }

    @Test
    fun typeNonValide() {
        typeDuPersonnage.type = "0"
        val expected = false
        assert(expected == typeDuPersonnage.verifierType())
    }
}