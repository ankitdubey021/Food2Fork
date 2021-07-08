package com.ankitdubey021.food2fork.android.di

import com.ankitdubey021.food2fork.datasource.cache.RecipeCache
import com.ankitdubey021.food2fork.datasource.network.RecipeService
import com.ankitdubey021.food2fork.interectors.recipe_details.GetRecipe
import com.ankitdubey021.food2fork.interectors.recipe_list.SearchRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideSearchRecipe(
        recipeService: RecipeService,
        recipeCache: RecipeCache
    ): SearchRecipes {
        return SearchRecipes(recipeService, recipeCache)
    }

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeCache: RecipeCache
    ): GetRecipe {
        return GetRecipe(recipeCache = recipeCache)
    }

}
