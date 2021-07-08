package com.ankitdubey021.food2fork.presentation.recipe_list

import com.ankitdubey021.food2fork.domain.model.Recipe

data class RecipeListState(
    val isLoading : Boolean = false,
    val page : Int = 1,
    val query : String = "",
    val recipes : List<Recipe> = listOf()
)