package com.ankitdubey021.food2fork.android.presentation.recipe_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitdubey021.food2fork.interectors.recipe_list.SearchRecipes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val savedStateHandle: SavedStateHandle,
    private val searchRecipes: SearchRecipes
): ViewModel() {

    init {
        loadRecipes()
    }

    fun loadRecipes(){
        searchRecipes.execute(
            1,"Sweet"
        ).onEach { dataState ->

            println("VM : ${dataState.isLoading}")

            dataState.data?.let { recipes->
                println("VM : ${recipes}")
            }

            println("VM : ${dataState.message}")

        }.launchIn(viewModelScope)
    }

}