package donjon

class Donjon {
    private var donjon: MutableList<MutableList<Salle>> = mutableListOf()

    init {
        genererSallesVertical()
        println(donjon)
    }

    private fun genererSallesVertical() {
        for (indexVertical in 0..1) {
            donjon.add(indexVertical, genererSallesHorizontal(indexVertical))
        }
    }

    private fun genererSallesHorizontal(indexVertical: Int): MutableList<Salle> {
        val sallesHorizontal: MutableList<Salle> = mutableListOf()
        for (indexHorizontal in 0..1) {
            sallesHorizontal.add(indexHorizontal, Salle()
                .genererSalle(
                    contientMonstre = false,
                    contientCoffre = false,
                    sallePosition = intArrayOf(indexHorizontal, indexVertical)
                )
            )
        }
        return sallesHorizontal
    }

    fun obtenirSalleActuelle(personnagePosition: IntArray): Salle {
        return donjon[personnagePosition[0]][personnagePosition[1]]
    }
}