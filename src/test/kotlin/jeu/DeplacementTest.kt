package jeu

import domain.model.jeu.*
import domain.model.personnage.Personnage
import domain.port.serverside.SauvegardeDuJeu
import infrastructure.SauvegardeFichier
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DeplacementTest {
    private lateinit var carte: Carte
    private lateinit var grille: Grille
    private lateinit var gestionTransitionGrille: GestionTransitionGrille
    private lateinit var deplacement: Deplacement
    private lateinit var sauvegardeJeu: SauvegardeDuJeu
    private lateinit var personnage: Personnage

    // Ajouter des fonctions pour gérer les redondances dans les tests

    @BeforeEach
    fun setUp() {
        carte = Carte()
        carte.creerCarte()
        grille = Grille()
        grille.creerGrille()
        gestionTransitionGrille = GestionTransitionGrille(carte)
        sauvegardeJeu = SauvegardeFichier()
        personnage = Personnage()
        deplacement = Deplacement(grille, gestionTransitionGrille, sauvegardeJeu, personnage)
    }

    @Test
    fun `Lorsque je déplace mon personnage sur une case vide, le joueur est déplacé`() {
        //Given
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        //When
        val resultat = deplacement.position
        //Then
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun deplacementVersCaseMonstre() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Monstre)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(0, 0)
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun deplacementHorsGrille() {
        deplacement.position = Position(0, 0)
        deplacement.commandeDeplacement("N")
        val positionAttendu = Position(0, 0)
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
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
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun deplacementVersCaseTresor() {
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Tresor)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun deplacementHorsGrilleMax() {
        deplacement.position = Position(0, 4)
        deplacement.commandeDeplacement("S")
        val positionAttendu = Position(0, 4)
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun orientationDePersonnage() {
        deplacement.position = Position(2, 2)
        deplacement.direction = domain.model.jeu.Direction.NORD
        deplacement.commandeDeplacement("D")
        val orientationAttendu = domain.model.jeu.Direction.EST
        val resultat = deplacement.direction
        assertEquals(orientationAttendu, resultat)
    }


    @Test
    fun enchainementOrientation() {
        deplacement.position = Position(2, 2)
        deplacement.direction = domain.model.jeu.Direction.NORD
        deplacement.commandeDeplacement("D")
        deplacement.commandeDeplacement("G")
        val orientationAttendu = domain.model.jeu.Direction.NORD
        val resultat = deplacement.direction
        assertEquals(orientationAttendu, resultat)

    }

    @Test
    fun deplacementParOrientation() {
        deplacement.position = Position(2, 2)
        deplacement.direction = domain.model.jeu.Direction.EST
        grille.ajouterContenuCase(Position(3, 2), Vide)
        deplacement.commandeDeplacement("A")
        val positionAttendu = Position(3, 2)
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }

    @Test
    fun enchainementOrientationEtDeplacement() {
        deplacement.position = Position(0, 0)
        deplacement.direction = domain.model.jeu.Direction.SUD
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
        val resultat = deplacement.position
        assertEquals(positionAttendu, resultat)
    }
}