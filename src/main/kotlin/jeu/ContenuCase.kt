package jeu

import kotlinx.serialization.Serializable

@Serializable
sealed interface ContenuCase

@Serializable
data object Vide: ContenuCase

@Serializable
data object Mur: ContenuCase

@Serializable
data object Monstre: ContenuCase

@Serializable
data object Tresor: ContenuCase