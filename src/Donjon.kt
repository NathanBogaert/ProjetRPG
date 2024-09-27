import kotlin.random.Random

class Donjon() {
    lateinit var listeDesSalles: List<Salle>

    init {
        val nombreDeSalles = Random.nextInt(5, 10)
        var monstrePresent: Boolean
        var coffrePresent: Boolean
        var porteNordPresente: Boolean
        var porteSudPresente: Boolean
        var porteEstPresente: Boolean
        var porteOuestPresente: Boolean
        println("Le donjon contient $nombreDeSalles salles")
        for (i in 1..nombreDeSalles) {
            monstrePresent = Random.nextBoolean()
            coffrePresent = Random.nextBoolean()
            porteNordPresente = Random.nextBoolean()
            porteSudPresente = Random.nextBoolean()
            porteEstPresente = Random.nextBoolean()
            porteOuestPresente = if (porteNordPresente == false && porteSudPresente == false && porteEstPresente == false) {
                true
            } else {
                Random.nextBoolean()
            }
            listeDesSalles += Salle(
                contientUnMonstre = monstrePresent,
                contientUnCoffre = coffrePresent,
                porteNordDispo = porteNordPresente,
                porteSudDispo = porteSudPresente,
                porteEstDispo = porteEstPresente,
                porteOuestDispo = porteOuestPresente
            )
            for (i in 1..listeDesSalles.size) {
                println("Salle $i")
                println("Monstre ${listeDesSalles[i].contientUnMonstre}")
                println("Coffre ${listeDesSalles[i].contientUnCoffre}")
                println("Porte Nord ${listeDesSalles[i].porteNordDispo}")
                println("Porte Sud ${listeDesSalles[i].porteSudDispo}")
                println("Porte Est ${listeDesSalles[i].porteEstDispo}")
                println("Porte Ouest ${listeDesSalles[i].porteNordDispo}")
            }
        }
    }
}