package com.example.nexdish.survey

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SurveyViewModel(
    private val repository: SurveyRepository = SurveyRepository()
) : ViewModel() {

    // Q1~Q4
    var foodTypes = mutableStateListOf<String>()
    var cookingMethods = mutableStateListOf<String>()
    var countryFoods = mutableStateListOf<String>()
    var tastes = mutableStateListOf<String>()

    private val _saveState = MutableStateFlow<Boolean?>(null)
    val saveState = _saveState.asStateFlow()

    fun saveSurvey() {
        viewModelScope.launch {
            val result = repository.saveSurvey(
                foodTypes.toList(),
                cookingMethods.toList(),
                countryFoods.toList(),
                tastes.toList()
            )
            _saveState.value = result
        }
    }
}
