package com.ankitdubey021.food2fork.android.presentation.recipe_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ankitdubey021.food2fork.android.presentation.recipe_list.component.RecipeCard
import com.ankitdubey021.food2fork.android.presentation.recipe_list.component.RecipeList
import com.ankitdubey021.food2fork.android.presentation.theme.AppTheme
import com.ankitdubey021.food2fork.presentation.recipe_list.RecipeListState

@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onRecipeSelected: (Int) -> Unit
) {

    AppTheme(displayProgressBar = false) {
        RecipeList(
            laoding = state.isLoading,
            recipes = state.recipes,
            onClickRecipeListItem = onRecipeSelected
        )
    }
}