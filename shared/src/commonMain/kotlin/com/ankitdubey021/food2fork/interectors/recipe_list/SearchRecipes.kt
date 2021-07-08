package com.ankitdubey021.food2fork.interectors.recipe_list

import com.ankitdubey021.food2fork.datasource.cache.RecipeCache
import com.ankitdubey021.food2fork.datasource.network.RecipeService
import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService: RecipeService,
    private val recipeCache: RecipeCache
) {

    fun execute(
        page: Int,
        query: String
    ): Flow<DataState<List<Recipe>>> = flow {

        emit(DataState.loading())

        try {
            val recipe = recipeService.search(page, query)

            recipeCache.insert(recipe)

            val cacheResult = if(query.isBlank()){
                recipeCache.getAll(page = page)
            }else
                recipeCache.search(query = query, page = page)

            emit(DataState.data(message = null , data = cacheResult))

        }catch (ex : Exception){
            emit(DataState.error<List<Recipe>>(message = ex.message?:"Unknown error"))
        }

    }
}