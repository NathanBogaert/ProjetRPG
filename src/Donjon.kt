class Donjon(
    var donjon: List<List<Salle>> = listOf()
) {
    init {
        donjon = listOf(
            listOf(
                Salle(
                    contientCoffre = false,
                    contientMonstre = false,
                    porteNordDispo = false,
                    porteEstDispo = true,
                    porteSudDispo = true,
                    porteOuestDispo = false
                ),Salle(
                    contientCoffre = true,
                    contientMonstre = false,
                    porteNordDispo = false,
                    porteEstDispo = false,
                    porteSudDispo = true,
                    porteOuestDispo = true
                )
            ),
            listOf(
                Salle(
                    contientCoffre = false,
                    contientMonstre = true,
                    porteNordDispo = true,
                    porteEstDispo = true,
                    porteSudDispo = false,
                    porteOuestDispo = false
                ),Salle(
                    contientCoffre = true,
                    contientMonstre = true,
                    porteNordDispo = true,
                    porteEstDispo = false,
                    porteSudDispo = false,
                    porteOuestDispo = true
                )
            )
        )
    }
}