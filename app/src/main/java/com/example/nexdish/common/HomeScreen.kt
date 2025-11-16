package com.example.nexdish.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nexdish.common.model.TodayMeal
import com.example.nexdish.navigation.BottomNavigationBar

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = { HomeTopBar(onMenuClick = {}, onProfileClick = {}) },
        bottomBar = { BottomNavigationBar(navController) }   // 🔥 여기 변경됨
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {
            Spacer(Modifier.height(12.dp))

            Text(
                text = "Hello ${uiState.userName}!",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Have a nice day.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(Modifier.height(20.dp))

            HomeTabSection(
                selected = uiState.selectedTab,
                onSelect = { viewModel.updateTab(it) }
            )

            Spacer(Modifier.height(16.dp))

            uiState.quickPickMeal?.let {
                MealCardLarge(
                    title = "Today's Meal",
                    subtitle = it.subtitle,
                    onClick = { navController.navigate("instantRecommend") }
                )
            }

            Spacer(Modifier.height(12.dp))

            uiState.nearbyMeal?.let {
                MealCardLarge(
                    title = "Best Around You",
                    subtitle = it.subtitle,
                    onClick = { navController.navigate("nearby") }
                )
            }

            Spacer(Modifier.height(20.dp))

            Text("Today", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

            Spacer(Modifier.height(8.dp))

            LazyColumn {
                items(uiState.todayMeals) { meal ->
                    TodayMealRow(
                        meal = meal,
                        onClick = { navController.navigate("recordDetail/${meal.id}") }
                    )
                }
            }
        }
    }
}

/* --- 이하 동일 (TopBar, Tabs, Cards, TodayRow, BottomNav) --- */
