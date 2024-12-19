package personnage

import kotlinx.serialization.Serializable

@Serializable
class Personnage {
    val nom: NomDuPersonnage = NomDuPersonnage()
    val type: TypeDuPersonnage = TypeDuPersonnage()

    fun afficherInfo() {
        return println("""Nom: ${nom.afficherNom()}
            |${type.afficherStatistiques()}""".trimMargin()
        )
    }
}