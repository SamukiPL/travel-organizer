package me.samuki.navigation.ext

import androidx.navigation.NavController

fun NavController.getString(key: String): String? = currentBackStackEntry
    ?.arguments
    ?.getString(key)
