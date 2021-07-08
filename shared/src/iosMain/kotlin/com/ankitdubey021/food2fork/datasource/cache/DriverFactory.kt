package com.ankitdubey021.food2fork.datasource.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
    actual fun createDriver() : SqlDriver{
        return NativeSqliteDriver(RecipeDatabase.Schema, "recipes.db")
    }
}