package com.example.nexdish.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nexdish.auth.LoginScreen
import com.example.nexdish.auth.RegisterScreen
import com.example.nexdish.ui.common.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "login"   // 앱 첫 화면
    ) {
        // ✅ 로그인 화면
        composable("login") {
            LoginScreen(navController = navController)
        }

        // ✅ 회원가입 화면
        composable("register") {
            RegisterScreen(navController = navController)
        }

        // ✅ 홈 화면 (로그인 성공 시 이동)
        composable("home") {
            HomeScreen()
        }
    }
}
