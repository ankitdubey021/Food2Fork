package com.ankitdubey021.food2fork.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.ankitdubey021.food2fork.android.presentation.navigation.Navigation
import com.ankitdubey021.food2fork.datasource.network.KtorClientFactory
import com.ankitdubey021.food2fork.datasource.network.RecipeServiceImpl
import com.ankitdubey021.food2fork.datasource.network.RecipeServiceImpl.Companion.BASE_URL
import com.ankitdubey021.food2fork.datasource.network.model.RecipeDto
import com.ankitdubey021.food2fork.datasource.network.toRecipe
import com.ankitdubey021.food2fork.domain.utils.DatetimeUtil
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ktorClient = KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val recipeId = 1551

            val recipeServie = RecipeServiceImpl(ktorClient, BASE_URL)
            val recipe = recipeServie.get(recipeId)
            println("KtorTest: ${recipe.title}")
            println("KtorTest: ${recipe.dateUpdated}")
            println("KtorTest: ${DatetimeUtil().humanizeDatetime(recipe.dateUpdated)}")
        }


        setContent {
            Navigation()
        }
    }
}
