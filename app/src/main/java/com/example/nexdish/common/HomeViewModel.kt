package com.example.nexdish.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nexdish.common.model.MealCard
import com.example.nexdish.common.model.TodayMeal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HomeUiState(
    val userName: String = "Subin",
    val todayMeals: List<TodayMeal> = emptyList(),
    val quickPickMeal: MealCard? = null,
    val nearbyMeal: MealCard? = null,
    val selectedTab: HomeTab = HomeTab.Main
)

enum class HomeTab { Main, ForYou, NewToday }

class HomeViewModel(
    private val repository: HomeRepository = HomeRepositoryImpl()
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadHomeData("USER_ID")
    }

    fun loadHomeData(userId: String) {
        viewModelScope.launch {
            val today = repository.getTodayMeals(userId)
            val quick = repository.getQuickPickMeal(userId)
            val near = repository.getNearbyRestaurant(userId)

            _uiState.value = _uiState.value.copy(
                todayMeals = today,
                quickPickMeal = quick,
                nearbyMeal = near
            )
        }
    }

    fun updateTab(tab: HomeTab) {
        _uiState.value = _uiState.value.copy(selectedTab = tab)
    }
}
