package com.ankitdubey021.food2fork.android.presentation.recipe_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitdubey021.food2fork.domain.model.Recipe
import com.ankitdubey021.food2fork.interectors.recipe_details.GetRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getRecipe: GetRecipe
): ViewModel(){
    val recipe : MutableState<Recipe?> = mutableStateOf(null)

    init {
        savedStateHandle.get<Int>("recipeId")?.let {
            viewModelScope.launch {
                getRecipes(it)
            }
        }
    }

    private fun getRecipes(recipeId : Int){
        getRecipe.execute(recipeId = recipeId).onEach { dataState->

            println("VM : ${dataState.isLoading}")
            println("::::::;${dataState.data}")
            dataState.data?.let {
                recipe.value = it
            }

            println("VM : ${dataState.message}")

        }.launchIn(viewModelScope)
    }
}