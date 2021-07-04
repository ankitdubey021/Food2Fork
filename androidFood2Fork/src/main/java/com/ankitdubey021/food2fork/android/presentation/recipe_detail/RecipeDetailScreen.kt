package com.ankitdubey021.food2fork.android.presentation.recipe_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ankitdubey021.food2fork.domain.model.Recipe

@Composable
fun RecipeDetailScreen(recipe : Recipe?){
    if(recipe == null){
        Text(text = "Unable to get recipe details")
    }
    else{
        Column() {
            Text(text = "${recipe.title}")
            Text(text = "${recipe.ingredients}")
        }
    }

}