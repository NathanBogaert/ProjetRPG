package jeu

import application.AffichageSimple
import application.IHMDuJeu
import domain.model.jeu.*
import domain.model.personnage.Guerrier
import domain.model.personnage.Personnage
import domain.model.personnage.TypeDuPersonnageFactory
import domain.port.serverside.SauvegardeDuJeu
import domain.service.DeplacementService
import domain.service.SauvegardeService
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
    private lateinit var typeDuPersonnageFactory: TypeDuPersonnageFactory
    private lateinit var personnage: Personnage
    private lateinit var deplacementService: DeplacementService
    private lateinit var sauvegardeService: SauvegardeService
    private lateinit var affichageSimple: AffichageSimple
    private lateinit var ihm: IHMDuJeu

    @BeforeEach
    fun setUp() {
        carte = Carte()
        carte.largeur = 1
        carte.hauteur = 1
        carte.creerCarte()
        grille = carte.obtenirGrille(Position(0,0))!!
        gestionTransitionGrille = GestionTransitionGrille(carte)
        typeDuPersonnageFactory = TypeDuPersonnageFactory()
        personnage = Personnage(typeDuPersonnageFactory)
        personnage.nomDuPersonnage.nom = "nomtest"
        personnage.typeDuPersonnage.classe = Guerrier()
        sauvegardeJeu = SauvegardeFichier()
        sauvegardeService = SauvegardeService(sauvegardeJeu, personnage, carte)
        affichageSimple = AffichageSimple()
        ihm = IHMDuJeu(affichageSimple)
        deplacementService = DeplacementService(gestionTransitionGrille, grille, sauvegardeService, ihm)
        deplacement = Deplacement(deplacementService)
    }

    private fun deplacementVersCase(contenuCase: ContenuCase, positionAttendu: Position): Position {
        deplacementService.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), contenuCase)
        deplacement.commandeDeplacement("E")
        return positionAttendu
    }

    @Test
    fun `Lorsque je déplace mon personnage sur une case vide, le personnage est déplacé`() {
        // Given
        val positionAttendu = deplacementVersCase(Vide, Position(1, 0))
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque je déplace mon personnage sur une case contenant un monstre, le personnage n'est pas déplacé`() {
        // Given
        val positionAttendu = deplacementVersCase(Monstre, Position(0, 0))
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque je déplace mon personnage hors de la grille, le personnage n'est pas déplacé`() {
        // Given
        deplacementService.position = Position(0, 0)
        deplacement.commandeDeplacement("N")
        val positionAttendu = Position(0, 0)
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque j'enchaine des déplacements avec mon personnage, le personnage est déplacé à chaques positions`() {
        // Given
        deplacementService.position = Position(0, 0)
        grille.ajouterContenuCase(Position(1, 0), Vide)
        grille.ajouterContenuCase(Position(1, 1), Vide)
        grille.ajouterContenuCase(Position(2, 1), Vide)
        deplacement.commandeDeplacement("E")
        deplacement.commandeDeplacement("S")
        deplacement.commandeDeplacement("E")
        val positionAttendu = Position(2, 1)
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque mon personnage se déplace vers une case contenant un trésor, le personnage est déplacé`() {
        // Given
        val positionAttendu = deplacementVersCase(Tresor, Position(1, 0))
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque mon personnage se déplace au delà de la taille max de la grille, le personnage n'est pas déplacé`() {
        // Given
        deplacementService.position = Position(0, 4)
        deplacement.commandeDeplacement("S")
        val positionAttendu = Position(0, 4)
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    @Test
    fun `Lorsque le personnage à une orientation vers le Nord et se tourne vers la droite, le personnage à une orientation vers l'Est`() {
        // Given
        deplacementService.position = Position(2, 2)
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
        deplacementService.position = Position(2, 2)
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
        deplacementService.position = Position(2, 2)
        deplacement.direction = Direction.EST
        grille.ajouterContenuCase(Position(3, 2), Vide)
        deplacement.commandeDeplacement("A")
        val positionAttendu = Position(3, 2)
        // When
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }

    // Faire uniquement ce test au lieu de faire un test pour l'orientation / déplacement
    @Test
    fun `Lorsque le personnage enchaine les déplacement et orientation, le personnage se déplace et change son orientation`() {
        // Given
        deplacementService.position = Position(0, 0)
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
        val positionDuPersonnage = deplacementService.position
        // Then
        assertEquals(positionAttendu, positionDuPersonnage)
    }
}