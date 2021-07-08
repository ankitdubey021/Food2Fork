package com.ankitdubey021.food2fork.datasource.cache

import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DatetimeUtil
import com.squareup.sqldelight.db.SqlDriver

class RecipeDatabaseFactory(
    private val driverFactory : DriverFactory
){
    fun createDatabase() : RecipeDatabase{
        return RecipeDatabase(driverFactory.createDriver())
    }
}

expect class DriverFactory{
    fun createDriver() : SqlDriver
}

fun Recipe_Entity.toRecipe() : Recipe {

    val datetimeUtil = DatetimeUtil()

    return Recipe(
        id = id.toInt(),
        title = title,
        publisher = publisher,
        featuredImage = featured_image,
        rating = rating.toInt(),
        sourceUrl = source_url,
        ingredients = ingredients.convertIngredientsToList(),
        dateAdded = datetimeUtil.toLocalDate(date_added),
        dateUpdated =  datetimeUtil.toLocalDate(date_updated)
    )
}

fun List<Recipe_Entity>.toRecipeList() : List<Recipe> = map{
    it.toRecipe()
}

fun List<String>.string() = joinToString(separator = ",")
fun String.convertIngredientsToList() = split(",").toList()