package com.example.nexdish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.rememberNavController
import com.example.nexdish.navigation.AppNavGraph
import com.example.nexdish.ui.theme.NexDishTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Firebase 초기화 (매우 중요!)
        FirebaseApp.initializeApp(this)

        setContent {
            NexDishTheme(dynamicColor = false) {
                CompositionLocalProvider(
                    LocalViewModelOwner provides this
                ) {
                    val navController = rememberNavController()

                    AppNavGraph(
                        navController = navController
                    )
                }
            }
        }
    }
}

val LocalViewModelOwner = staticCompositionLocalOf<ViewModelStoreOwner> {
    error("ViewModelStoreOwner가 CompositionLocal에 제공되지 않았습니다.")
}
