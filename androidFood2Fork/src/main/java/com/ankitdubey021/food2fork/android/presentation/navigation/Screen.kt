package com.ankitdubey021.food2fork.android.presentation.navigation

sealed class Screen (val route : String) {
    object RecipeList : Screen("recipeList")
    object RecipeDetail : Screen("recipeDetail")
}