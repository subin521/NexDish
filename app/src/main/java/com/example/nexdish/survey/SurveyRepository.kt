package com.example.nexdish.survey

import com.example.nexdish.data.FirestoreHelper

class SurveyRepository(
    private val firestoreHelper: FirestoreHelper = FirestoreHelper()
) {

    suspend fun saveSurvey(
        foodTypes: List<String>,
        cookingMethods: List<String>,
        countryFoods: List<String>,
        tastes: List<String>
    ): Boolean {
        return firestoreHelper.saveSurvey(foodTypes, cookingMethods, countryFoods, tastes)
    }
}
