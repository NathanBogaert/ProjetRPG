import personnage.domain.Personnage

// Sujet: https://github.com/remihamy1/ProjetRPG/tree/main

fun main() {
    val personnage = Personnage()
    personnage.nom.ajouterNom()
    personnage.type.choixDuType()
    personnage.afficherInfo()
}