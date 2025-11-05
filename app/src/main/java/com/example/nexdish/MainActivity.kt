package com.example.nexdish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nexdish.navigation.AppNavGraph
import com.example.nexdish.ui.theme.NexDishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexDishTheme {
                AppNavGraph()
            }
        }
    }
}
