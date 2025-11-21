package com.example.nexdish.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nexdish.auth.LoginScreen
import com.example.nexdish.auth.RegisterScreen
import com.example.nexdish.common.CalendarScreen
import com.example.nexdish.common.HomeScreen
import com.example.nexdish.common.ProfileScreen
import com.example.nexdish.survey.SurveyQ1Screen
import com.example.nexdish.survey.SurveyQ2Screen
import com.example.nexdish.survey.SurveyQ3Screen
import com.example.nexdish.survey.SurveyQ4Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {

    val currentUser = FirebaseAuth.getInstance().currentUser

    //  자동 로그인 적용
    val startRoute = if (currentUser != null) "home" else "login"

    NavHost(
        navController = navController,
        startDestination = startRoute
    ) {

        // 로그인
        composable("login") {
            LoginScreen(navController)
        }

        // 회원가입
        composable("register") {
            RegisterScreen(navController)
        }

        // 설문
        composable("survey1") { SurveyQ1Screen(navController) }
        composable("survey2") { SurveyQ2Screen(navController) }
        composable("survey3") { SurveyQ3Screen(navController) }
        composable("survey4") { SurveyQ4Screen(navController) }

        composable("home") { HomeScreen(navController) }
        composable("calendar") { CalendarScreen(navController) }
        composable("profile") { ProfileScreen(navController) }

    }
}
