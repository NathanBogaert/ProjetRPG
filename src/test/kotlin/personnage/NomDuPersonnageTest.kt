package personnage

import org.junit.jupiter.api.Test

class NomDuPersonnageTest {
    private val nomDuPersonnage = NomDuPersonnage()

    @Test
    fun nomValide() {
        nomDuPersonnage.nom = "nathan"
        val expected = true
        assert(expected == nomDuPersonnage.verifierNom())
    }

    @Test
    fun nomTropCourt() {
        nomDuPersonnage.nom = ""
        val expected = false
        assert(expected == nomDuPersonnage.verifierNom())
    }

    @Test
    fun nomTropLong() {
        nomDuPersonnage.nom = "aaaaaaaaaaaaa"
        val expected = false
        assert(expected == nomDuPersonnage.verifierNom())
    }
}