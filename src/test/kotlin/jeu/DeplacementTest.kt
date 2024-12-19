package jeu

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import personnage.Personnage
import sauvegarde.Sauvegarde
import sauvegarde.SauvegardeDuJeu

class DeplacementTest {
    private lateinit var carte: Carte
    private lateinit var grille: Grille
    private lateinit var gestionTransitionGrille: GestionTransitionGrille
    private lateinit var deplacement: Deplacement
    private lateinit var sauvegardeJeu: SauvegardeDuJeu

    @BeforeEach
    fun setUp() {
        carte = Carte()
        carte.creerCarte()
        grille = Grille()
        grille.creerGrille()
        gestionTransitionGrille = GestionTransitionGrille(carte)
        sauvegardeJeu = Sauvegarde()
        deplacement = Deplacement(grille, gestionTransitionGrille, sauvegardeJeu, )
    }

    @Test
    fun deplacementVersCaseVide() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun deplacementVersCaseMonstre() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Monstre)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(0, 0)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun deplacementHorsGrille() {
        deplacement.position = Position(0, 0)
        deplacement.commandeDeplacement("N")
        val positionAttendu = Position(0, 0)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun enchainementDeDeplacement() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        grille.ajouterContenuCase(Position(1, 1), Vide)
        grille.ajouterContenuCase(Position(2, 1), Vide)
        deplacement.commandeDeplacement("E")
        deplacement.commandeDeplacement("S")
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(2, 1)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun deplacementVersCaseTresor() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Tresor)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun deplacementHorsGrilleMax() {
        deplacement.position = Position(0, 4)
        deplacement.commandeDeplacement("S")
        val positionAttendu = Position(0, 4)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun orientationDePersonnage() {
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.NORD
        deplacement.commandeDeplacement("D")
        val orientationAttendu = Direction.EST
        assertEquals(orientationAttendu, deplacement.direction)
    }

    @Test
    fun enchainementOrientation() {
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.NORD
        deplacement.commandeDeplacement("D")
        deplacement.commandeDeplacement("G")
        val orientationAttendu = Direction.NORD
        assertEquals(orientationAttendu, deplacement.direction)

    }

    @Test
    fun deplacementParOrientation() {
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.EST
        grille.ajouterContenuCase(Position(3, 2), Vide)
        deplacement.commandeDeplacement("A")
        val positionAttendu = Position(3, 2)
        assertEquals(positionAttendu, deplacement.position)
    }

    @Test
    fun enchainementOrientationEtDeplacement() {
        deplacement.position = Position(0, 0)
        deplacement.direction = Direction.SUD
        grille.ajouterContenuCase(Position(0, 1), Vide)
        grille.ajouterContenuCase(Position(1, 1), Vide)
        grille.ajouterContenuCase(Position(1, 2), Vide)
        grille.ajouterContenuCase(Position(1, 3), Vide)
        deplacement.commandeDeplacement("A")
        deplacement.commandeDeplacement("G")
        deplacement.commandeDeplacement("A")
        deplacement.commandeDeplacement("D")
        deplacement.commandeDeplacement("A")
        deplacement.commandeDeplacement("A")
        val positionAttendu = Position(1, 3)
        assertEquals(positionAttendu, deplacement.position)
    }
}