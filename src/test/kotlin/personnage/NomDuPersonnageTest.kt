package personnage

import org.junit.jupiter.api.Test

class NomDuPersonnageTest {
    private val nomDuPersonnage = NomDuPersonnage()

    @Test
    fun nomValide() {
        val nom = "nathan"
        val expected = true
        val resultat = nomDuPersonnage.nomValide(nom)
        assert(expected == resultat)
    }

    @Test
    fun nomTropCourt() {
        val nom = ""
        val expected = false
        val resultat = nomDuPersonnage.nomValide(nom)
        assert(expected == resultat)
    }

    @Test
    fun nomTropLong() {
        val nom = "aaaaaaaaaaaaa"
        val expected = false
        val resultat = nomDuPersonnage.nomValide(nom)
        assert(expected == resultat)
    }
}