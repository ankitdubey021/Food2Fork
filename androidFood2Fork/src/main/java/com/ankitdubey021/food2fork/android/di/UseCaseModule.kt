package com.ankitdubey021.food2fork.android.di

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
        recipeService: RecipeService
    ): SearchRecipes {
        return SearchRecipes(recipeService)
    }

    @Singleton
    @Provides
    fun provideGetRecipe(
        recipeService: RecipeService
    ): GetRecipe {
        return GetRecipe(recipeService)
    }

}
