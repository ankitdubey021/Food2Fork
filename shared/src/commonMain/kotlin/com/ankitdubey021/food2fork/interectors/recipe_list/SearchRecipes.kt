package com.ankitdubey021.food2fork.interectors.recipe_list

import com.ankitdubey021.food2fork.datasource.network.RecipeService
import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService
) {

    fun execute(
        page: Int,
        query: String
    ): Flow<DataState<List<Recipe>>> = flow {

        emit(DataState.loading())

        try {
            val recipe = recipeService.search(page, query)
            emit(DataState.data(message = null , data = recipe))

        }catch (ex : Exception){
            emit(DataState.error<List<Recipe>>(message = ex.message?:"Unknown error"))
        }

    }
}