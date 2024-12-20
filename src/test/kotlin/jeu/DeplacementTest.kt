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
    fun `Lorsque je déplace mon personnage sur une case vide, le personnage est déplacé`() {
        // Given
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque je déplace mon personnage sur une case contenant un monstre, le personnage n'est pas déplacé`() {
        // Given
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Monstre)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(0, 0)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque je déplace mon personnage hors de la grille, le personnage n'est pas déplacé`() {
        // Given
        deplacement.position = Position(0, 0)
        deplacement.commandeDeplacement("N")
        val positionAttendu = Position(0, 0)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque j'enchaine des déplacements avec mon personnage, le personnage est déplacé à chaques positions`() {
        // Given
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        grille.ajouterContenuCase(Position(1, 1), Vide)
        grille.ajouterContenuCase(Position(2, 1), Vide)
        deplacement.commandeDeplacement("E")
        deplacement.commandeDeplacement("S")
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(2, 1)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque mon personnage se déplace vers une case contenant un trésor, le personnage est déplacé`() {
        // Given
        deplacement.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Tresor)
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(1, 0)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque mon personnage se déplace au delà de la taille max de la grille, le personnage n'est pas déplacé`() {
        // Given
        deplacement.position = Position(0, 4)
        deplacement.commandeDeplacement("S")
        val positionAttendu = Position(0, 4)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque le personnage à une orientation vers le Nord et se tourne vers la droite, le personnage à une orientation vers l'Est`() {
        // Given
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.NORD
        deplacement.commandeDeplacement("D")
        val orientationAttendu = Direction.EST
        // When
        val directionDuPersonnage = deplacement.direction
        // Then
        assertEquals(orientationAttendu, directionDuPersonnage)
    }


    @Test
    fun `Lorsque le personnage enchaine les orientations, le personnage change son orientation à chaque changements d'orientation`() {
        // Given
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.NORD
        deplacement.commandeDeplacement("D")
        deplacement.commandeDeplacement("G")
        val orientationAttendu = Direction.NORD
        // When
        val directionDuPersonnage = deplacement.direction
        // Then
        assertEquals(orientationAttendu, directionDuPersonnage)

    }

    @Test
    fun `Lorsque le personnage se déplace par rapport à son orientation, le personnage se déplace`() {
        // Given
        deplacement.position = Position(2, 2)
        deplacement.direction = Direction.EST
        grille.ajouterContenuCase(Position(3, 2), Vide)
        deplacement.commandeDeplacement("A")
        val positionAttendu = Position(3, 2)
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    // Faire uniquement ce test au lieu de faire un test pour l'orientation / déplacement
    @Test
    fun `Lorsque le personnage enchaine les déplacement et orientation, le personnage se déplace et change son orientation`() {
        // Given
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
        // When
        val positionDuPersonnage = deplacement.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }
}