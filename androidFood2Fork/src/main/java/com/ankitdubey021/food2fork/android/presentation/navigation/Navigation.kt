package com.ankitdubey021.food2fork.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.ankitdubey021.food2fork.android.presentation.recipe_detail.RecipeDetailScreen
import com.ankitdubey021.food2fork.android.presentation.recipe_list.RecipeListScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeList.route){
        composable(Screen.RecipeList.route){
            RecipeListScreen(
                onRecipeSelected = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
                }
            )
        }

        composable(
            Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ){ navBackStackEntry ->
            RecipeDetailScreen(recipeId = navBackStackEntry.arguments?.getInt("recipeId"))
        }
    }
}