package personnage

import domain.model.personnage.NomDuPersonnage
import org.junit.jupiter.api.Test

class NomDuPersonnageTest {
    private val nomDuPersonnage = NomDuPersonnage()

    @Test
    fun estValide() {
        val nom = "nathan"
        val expected = true
        val resultat = nomDuPersonnage.estValide(nom)
        assert(expected == resultat)
    }

    @Test
    fun nomTropCourt() {
        val nom = ""
        val expected = false
        val resultat = nomDuPersonnage.estValide(nom)
        assert(expected == resultat)
    }

    @Test
    fun nomTropLong() {
        val nom = "aaaaaaaaaaaaa"
        val expected = false
        val resultat = nomDuPersonnage.estValide(nom)
        assert(expected == resultat)
    }
}