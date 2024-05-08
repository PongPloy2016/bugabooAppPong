package com.example.bugabooapppong.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.example.bugabooapppong.ui.components.ErrorComponent
import com.example.bugabooapppong.ui.components.LoadingComponent
import com.example.bugabooapppong.ui.components.SuccessComponent
import com.example.bugabooapppong.ui.viewmodel.HomeViewModel
import com.example.bugabooapppong.ui.viewmodel.HomeViewState

@Composable
fun HomeScreen(recipeViewModel: HomeViewModel) {
    val state by recipeViewModel.state

    when(state) {
        is HomeViewState.Loading -> LoadingComponent()
        is HomeViewState.Success -> {
            val recipes = (state as HomeViewState.Success).mainResponse
            SuccessComponent(recipes = recipes, onSearchClicked = {query ->
              //  recipeViewModel.processIntent(RecipeViewIntent.SearchRecipes(query))
            })
        }
        is HomeViewState.Error -> {
            val message = (state as HomeViewState.Error).message
            ErrorComponent(message = message, onRefreshClicked = {
                recipeViewModel.vmGetUserList()
            })
        }
    }

    LaunchedEffect(Unit) {
        recipeViewModel.loadRandomRecipe()
    }
}