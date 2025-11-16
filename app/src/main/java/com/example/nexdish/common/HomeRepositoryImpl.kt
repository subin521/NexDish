package com.example.nexdish.common

import com.example.nexdish.common.model.MealCard
import com.example.nexdish.common.model.TodayMeal
import com.example.nexdish.data.FirestoreHelper

class HomeRepositoryImpl(
    private val firestore: FirestoreHelper = FirestoreHelper()
) : HomeRepository {

    override suspend fun getTodayMeals(userId: String): List<TodayMeal> {
        return firestore.getTodayMeals(userId)
    }

    override suspend fun getQuickPickMeal(userId: String): MealCard {
        val menu = firestore.getQuickPick(userId)
        return MealCard(
            title = menu.name,
            subtitle = "${menu.type} · ${menu.time}"
        )
    }

    override suspend fun getNearbyRestaurant(userId: String): MealCard {
        val restaurant = firestore.getNearby(userId)
        return MealCard(
            title = restaurant.name,
            subtitle = "${restaurant.distance}m · ${restaurant.time} min"
        )
    }
}
