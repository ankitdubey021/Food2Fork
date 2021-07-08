package com.ankitdubey021.food2fork.interectors.recipe_details

import com.ankitdubey021.food2fork.datasource.cache.RecipeCache
import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(
    private val recipeCache: RecipeCache
) {
    fun execute(
        recipeId: Int
    ): Flow<DataState<Recipe>> = flow {

        emit(DataState.loading())
        try {
            val recipe = recipeCache.getRecipe(recipeId)
            emit(DataState.data(message = null, data = recipe))
        } catch (ex: Exception) {
            ex.printStackTrace()
            emit(DataState.error<Recipe>(message = ex.message ?: "Unknown error"))
        }

    }

}