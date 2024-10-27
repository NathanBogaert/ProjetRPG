package donjon

class Salle {
    private var contientMonstre: Boolean = false
    private var contientCoffre: Boolean = false
    private var porte: List<Boolean> = listOf(false, false, false, false)

    fun genererSalle(contientMonstre: Boolean, contientCoffre: Boolean, sallePosition: IntArray): Salle {
        this.contientMonstre = contientMonstre
        this.contientCoffre = contientCoffre
        this.porte = genererPortes(sallePositionX = sallePosition[0], sallePositionY = sallePosition[1], 1, 1)
        return this
    }

    private fun genererPortes(sallePositionX: Int, sallePositionY: Int, maxPositionX: Int, maxPositionY: Int): List<Boolean> {
        return when {
            sallePositionX == 0 && sallePositionY == 0 -> PorteCoinHautGauche().obtenirPortes()
            sallePositionX == maxPositionX && sallePositionY == maxPositionY -> PorteCoinBasDroit().obtenirPortes()
            sallePositionX == 0 && sallePositionY == maxPositionY -> PorteCoinBasGauche().obtenirPortes()
            sallePositionX == maxPositionX && sallePositionY == 0 -> PorteCoinHautDroit().obtenirPortes()
            sallePositionX == 0 -> PorteBordGauche().obtenirPortes()
            sallePositionY == 0 -> PorteBordHaut().obtenirPortes()
            sallePositionX == maxPositionX -> PorteBordDroit().obtenirPortes()
            sallePositionY == maxPositionY -> PorteBordBas().obtenirPortes()
            else -> PorteCentre().obtenirPortes()
        }
    }

    fun obtenirMonstre(): Boolean {
        return contientMonstre
    }

    fun obtenirCoffre(): Boolean {
        return contientCoffre
    }

    fun obtenirPorteNord(): Boolean {
        return porte[0]
    }

    fun obtenirPorteSud(): Boolean {
        return porte[1]
    }

    fun obtenirPorteOuest(): Boolean {
        return porte[2]
    }

    fun obtenirPorteEst(): Boolean {
        return porte[3]
    }
}

class PorteCoinHautGauche: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(false, true, false, true)
}

class PorteCoinHautDroit: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(false, true, true, false)
}

class PorteCoinBasGauche: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, false, false, true)
}

class PorteCoinBasDroit: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, false, true, false)
}
class PorteBordHaut: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(false, true, true, true)
}

class PorteBordBas: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, false, true, true)
}

class PorteBordGauche: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, true, false, true)
}

class PorteBordDroit: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, true, true, false)
}

class PorteCentre: PortesDisponibles {
    override fun obtenirPortes(): List<Boolean> = listOf(true, true, true, true)
}