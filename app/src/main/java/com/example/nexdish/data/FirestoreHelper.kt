package com.example.nexdish.data

import com.example.nexdish.common.model.TodayMeal
import com.example.nexdish.data.model.Food
import com.example.nexdish.data.model.Restaurant
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

class FirestoreHelper {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    // --------------------------------------------------------
    // 1) 선호도 저장
    // --------------------------------------------------------
    suspend fun savePreferences(l1: String, l2: String, l3: String, l4: String): Boolean {
        val uid = auth.currentUser?.uid ?: return false

        val data = hashMapOf(
            "uid" to uid,
            "L1" to l1,
            "L2" to l2,
            "L3" to l3,
            "L4" to l4
        )

        return try {
            db.collection("preferences").document(uid).set(data).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // --------------------------------------------------------
    // 🔥 설문 결과 Q1~Q4 저장 (추천 알고리즘용)
    // /users/{uid}/preferences 아래 저장
    // --------------------------------------------------------
    suspend fun saveSurvey(foodTypes: List<String>, cookingMethods: List<String>, countryFoods: List<String>, tastes: List<String>): Boolean {

        val uid = auth.currentUser?.uid ?: return false

        val data = mapOf(
            "food_types" to foodTypes,
            "cooking_methods" to cookingMethods,
            "country_foods" to countryFoods,
            "tastes" to tastes
        )

        return try {
            db.collection("users")
                .document(uid)
                .set(mapOf("preferences" to data), SetOptions.merge())
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }


    // --------------------------------------------------------
    // 2) 오늘 먹은 음식 가져오기
    // Firestore 구조 예:
    // users/{uid}/foods/{foodId}
    // --------------------------------------------------------
    suspend fun getTodayMeals(userId: String): List<TodayMeal> {
        return try {
            val snapshot = db.collection("users")
                .document(userId)
                .collection("foods")
                .get()
                .await()

            snapshot.documents.mapNotNull { doc ->
                val food = doc.toObject(Food::class.java)
                food?.let {
                    TodayMeal(
                        id = doc.id,
                        name = it.name,
                        time = it.time
                    )
                }
            }

        } catch (e: Exception) {
            emptyList()
        }
    }


    // --------------------------------------------------------
    // 3) QuickPick 가져오기 (하루 추천 메뉴)
    // Firestore 구조 예:
    // quickpick/{uid}
    // --------------------------------------------------------
    suspend fun getQuickPick(userId: String): Food {
        val snapshot = db.collection("quickpick")
            .document(userId)
            .get()
            .await()

        return snapshot.toObject(Food::class.java)
            ?: Food(name = "추천 없음", type = "Unknown", time = "N/A")
    }


    // --------------------------------------------------------
    // 4) 주변 식당 가져오기 (Nearby Restaurant)
    // Firestore 구조 예:
    // nearby/{uid}
    // --------------------------------------------------------
    suspend fun getNearby(userId: String): Restaurant {
        val snapshot = db.collection("nearby")
            .document(userId)
            .get()
            .await()

        return snapshot.toObject(Restaurant::class.java)
            ?: Restaurant(name = "식당 없음", distance = 0, time = 0)
    }
}
