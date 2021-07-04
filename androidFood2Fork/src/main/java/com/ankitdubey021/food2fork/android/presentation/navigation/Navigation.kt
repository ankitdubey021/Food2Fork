package com.ankitdubey021.food2fork.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.ankitdubey021.food2fork.android.presentation.recipe_detail.RecipeDetailScreen
import com.ankitdubey021.food2fork.android.presentation.recipe_detail.RecipeDetailViewModel
import com.ankitdubey021.food2fork.android.presentation.recipe_list.RecipeListScreen
import com.ankitdubey021.food2fork.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.RecipeList.route) {
        composable(Screen.RecipeList.route) {
            val viewModel: RecipeListViewModel = hiltViewModel()
            RecipeListScreen(
                onRecipeSelected = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.route + "/$recipeId")
                }
            )
        }

        composable(
            Screen.RecipeDetail.route + "/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val viewModel: RecipeDetailViewModel = hiltViewModel()
            RecipeDetailScreen(recipe = viewModel.recipe.value)
        }
    }
}