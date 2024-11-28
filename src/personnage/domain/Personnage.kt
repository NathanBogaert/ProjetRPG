package personnage.domain

class Personnage {
    val nom: NomDuPersonnage = NomDuPersonnage()
    val type: TypeDuPersonnage = TypeDuPersonnage()

    fun afficherInfo() {
        return println("${nom.afficherNom()}\n${type.afficherType()}")
    }
}