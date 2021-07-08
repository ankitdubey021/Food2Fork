package com.ankitdubey021.food2fork.datasource.cache

import com.ankitdubey021.food2fork.domain.model.Recipe

interface RecipeCache {

    fun insert(recipe : Recipe)
    fun insert(recipList : List<Recipe>)
    fun search(query : String, page : Int) : List<Recipe>

    fun getAll(page: Int) : List<Recipe>

    fun getRecipe(recipeId : Int) : Recipe?

}