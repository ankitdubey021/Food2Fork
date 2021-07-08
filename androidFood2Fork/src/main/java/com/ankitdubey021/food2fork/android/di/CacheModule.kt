package com.ankitdubey021.food2fork.android.di

import android.content.Context
import com.ankitdubey021.food2fork.datasource.cache.*
import com.ankitdubey021.food2fork.domain.utils.DatetimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CacheModule {

    @Singleton
    @Provides
    fun provideRecipeDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return RecipeDatabaseFactory(driverFactory = DriverFactory(context)).createDatabase()
    }

    @Singleton
    @Provides
    fun provideRecipeCache(
        database: RecipeDatabase
    ): RecipeCache {
        return RecipeCacheImpl(database, datetimeUtil = DatetimeUtil())
    }

}