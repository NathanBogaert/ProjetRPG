# SRP

La classe IHMDuPersonnage a trop de responsabilités.
Séparer en plusieurs classes :
- CreationPersonnageIHM
- AffichagePersonnageIHM
- RecapitulatifPersonnageIHM

# OCP

 La gestion des types de personnages est rigide dans TypeDuPersonnage.

 Méthode trop longue dans DeplacementService.

# Value Objects
Les statistiques sont mutables.

# Pattern State
Problème : Utilisation excessive de conditions pour les états du jeu.

# Amélioration :
Ajouter des tests pour :
- La sauvegarde/chargement
- Les cas limites de création de personnage
- Les interactions avec les monstres
