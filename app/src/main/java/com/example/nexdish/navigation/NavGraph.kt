package com.example.nexdish.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nexdish.auth.LoginScreen
import com.example.nexdish.auth.RegisterScreen
import com.example.nexdish.common.HomeScreen
import com.example.nexdish.survey.SurveyQ1Screen
import com.example.nexdish.survey.SurveyQ2Screen
import com.example.nexdish.survey.SurveyQ3Screen
import com.example.nexdish.survey.SurveyQ4Screen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // 로그인
        composable("login") {
            LoginScreen(navController)
        }

        // 회원가입
        composable("register") {
            RegisterScreen(navController)
        }

        // 설문 1
        composable("survey1") {
            SurveyQ1Screen(navController)
        }

        // 설문 2
        composable("survey2") {
            SurveyQ2Screen(navController)
        }

        // 설문 3
        composable("survey3") {
            SurveyQ3Screen(navController)
        }

        // 설문 4
        composable("survey4") {
            SurveyQ4Screen(navController)
        }

        composable("home") { HomeScreen(navController) }
        composable("calendar") { CalendarScreen(navController) }
        composable("profile") { ProfileScreen(navController) }

    }
}
