package domain.model.personnage

class Personnage(
    typeDuPersonnageFactory: TypeDuPersonnageFactory
) {
    var nomDuPersonnage: NomDuPersonnage = NomDuPersonnage()
    var typeDuPersonnage: TypeDuPersonnage = TypeDuPersonnage(typeDuPersonnageFactory)
}