package com.ankitdubey021.food2fork.android.di

import com.ankitdubey021.food2fork.datasource.network.KtorClientFactory
import com.ankitdubey021.food2fork.datasource.network.RecipeService
import com.ankitdubey021.food2fork.datasource.network.RecipeServiceImpl
import com.ankitdubey021.food2fork.datasource.network.RecipeServiceImpl.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient() : HttpClient{
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,

    ) : RecipeService{
        return RecipeServiceImpl(httpClient = httpClient, BASE_URL)
    }

}