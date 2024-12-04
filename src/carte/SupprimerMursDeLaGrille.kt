package carte

class SupprimerMurGrilleCoinHautGauche : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }
}

class SupprimerMurGrilleCoinHautDroit : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }
}

class SupprimerMurGrilleCoinBasGauche : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
    }
}

class SupprimerMurGrilleCoinBasDroit : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
    }
}

class SupprimerMurGrilleBordHaut : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }
}

class SupprimerMurGrilleBordGauche : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }
}

class SupprimerMurGrilleBordDroit : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }
}

class SupprimerMurGrilleBordBas : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
    }
}

class SupprimerMurGrilleCentre : PresenceMur {
    override fun supprimerMursDeLaGrille(grille: List<List<Case>>) {
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.NORD)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.OUEST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.EST)
        GestionnaireDesMurs().supprimerUnMur(grille, EmplacementsMur.SUD)
    }

}