package com.ankitdubey021.food2fork.datasource.cache

import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DatetimeUtil

class RecipeCacheImpl(
    recipeDatabase: RecipeDatabase,
    private val datetimeUtil: DatetimeUtil
) : RecipeCache {

    private val queries: RecipeDBQueries = recipeDatabase.recipeDBQueries
    override fun insert(recipe: Recipe) {
        queries.insertRecipe(
            id = recipe.id.toLong(),
            title = recipe.title,
            publisher = recipe.publisher,
            featured_image = recipe.featuredImage,
            rating = recipe.rating.toLong(),
            source_url = recipe.sourceUrl,
            ingredients = recipe.ingredients.string(),//convert list
            date_added = datetimeUtil.toEpochMilliseconds(recipe.dateAdded),
            date_updated = datetimeUtil.toEpochMilliseconds(recipe.dateUpdated)
        )
    }

    override fun insert(recipList: List<Recipe>) {
        for (recipe in recipList) {
            insert(recipe)
        }
    }

    override fun search(query: String, page: Int): List<Recipe> {
        return queries.searchRecipes(
            query = query,
            pageSize = 30,
            offset = ((page - 1) * 30L)
        ).executeAsList().toRecipeList()
    }

    override fun getAll(page: Int): List<Recipe> {
        return queries.getAllRecipes(
            pageSize = 30,
            offset = ((page - 1) * 30L)
        ).executeAsList().toRecipeList()
    }

    override fun getRecipe(recipeId: Int): Recipe? {
        return try {
            queries
                .getRecipeById(recipeId.toLong())
                .executeAsOne().toRecipe()
        } catch (e: NullPointerException) {
            e.printStackTrace()
            null
        }
    }
}