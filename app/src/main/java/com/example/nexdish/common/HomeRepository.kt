package com.example.nexdish.common

import com.example.nexdish.common.model.MealCard
import com.example.nexdish.common.model.TodayMeal

interface HomeRepository {

    suspend fun getTodayMeals(userId: String): List<TodayMeal>

    suspend fun getQuickPickMeal(userId: String): MealCard

    suspend fun getNearbyRestaurant(userId: String): MealCard
}
