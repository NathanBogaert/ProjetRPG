package personnage

class Personnage {
    private val nom: NomDuPersonnage = NomDuPersonnage()
    private val type: TypeDuPersonnage = TypeDuPersonnage()
    private val statistiques: Statistiques = Statistiques()

    init {
        nom.ajouterNom()
        type.selectionnerType()
        statistiques.initiliserStatistiques(type)
    }

    fun afficherInfo() {
        return println("${nom.afficherNom()}\n${type.afficherType()}\n${statistiques.afficherStatistiques()}")
    }
}