package com.ankitdubey021.food2fork.android.presentation.recipe_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecipeDetailScreen(recipeId : Int?){
    Text(text = "Recipe Detail screen : $recipeId")
}