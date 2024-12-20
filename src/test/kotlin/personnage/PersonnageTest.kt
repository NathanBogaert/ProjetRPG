package personnage

import org.junit.jupiter.api.Test

class PersonnageTest {
    private val personnage = Personnage()

    @Test
    fun affichageInfoDuPersonnage() {
        personnage.nom.nom = "Nathan"
        personnage.type.type = Guerrier()
        val expected = """
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
        val resultat = personnage.afficherRecapitulatif()
        assert(expected == resultat)
    }
}