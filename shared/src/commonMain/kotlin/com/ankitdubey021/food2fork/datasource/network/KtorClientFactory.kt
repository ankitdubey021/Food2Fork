package com.ankitdubey021.food2fork.datasource.network

import com.ankitdubey021.food2fork.datasource.network.model.RecipeDto
import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.domain.utils.DatetimeUtil
import io.ktor.client.*
import kotlinx.datetime.LocalDateTime

expect class KtorClientFactory() {
    fun build(): HttpClient
}

fun RecipeDto.toRecipe(): Recipe {
    val dateUtil = DatetimeUtil()
    return Recipe(
        id = pk,
        title = title,
        featuredImage = featuredImage,
        rating = rating,
        publisher = publisher,
        sourceUrl = sourceUrl,
        ingredients = ingredients,
        dateAdded = dateUtil.toLocalDate(longDateAdded.toDouble()),
        dateUpdated = dateUtil.toLocalDate(longDateUpdaded.toDouble())
    )
}

fun List<RecipeDto>.toRecipeList(): List<Recipe> {
    return map {
        it.toRecipe()
    }
}