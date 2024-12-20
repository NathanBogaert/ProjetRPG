package personnage

class Personnage {
    var nom: NomDuPersonnage = NomDuPersonnage()
    var type: TypeDuPersonnage = TypeDuPersonnage()

    fun afficherInfo() {
        return println("""Nom: ${nom.afficherNom()}
            |${type.afficherStatistiques()}""".trimMargin()
        )
    }
}