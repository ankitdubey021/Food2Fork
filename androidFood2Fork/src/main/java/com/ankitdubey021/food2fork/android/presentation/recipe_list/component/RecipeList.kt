package com.ankitdubey021.food2fork.android.presentation.recipe_list.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.ankitdubey021.food2fork.domain.model.Recipe

@Composable
fun RecipeList(
    laoding : Boolean,
    recipes : List<Recipe>,
    onClickRecipeListItem: (Int) -> Unit
){
    if(laoding && recipes.isNullOrEmpty()){

    }
    else if (recipes.isEmpty()){

    }
    else{
        LazyColumn {
            itemsIndexed(
                items = recipes
            ){ index, recipe ->
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        onClickRecipeListItem(recipe.id)
                    }
                )
            }
        }
    }
}