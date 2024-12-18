package personnage

class Personnage {
    val nom: NomDuPersonnage = NomDuPersonnage()
    val type: TypeDuPersonnage = TypeDuPersonnage()

    fun afficherInfo() {
        return println("""Nom: ${nom.afficherNom()}
            |${type.afficherStatistiques()}""".trimMargin()
        )
    }
}