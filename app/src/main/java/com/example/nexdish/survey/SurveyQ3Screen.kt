package com.example.nexdish.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nexdish.LocalViewModelOwner

@Composable
fun SurveyQ3Screen(navController: NavController) {

    val owner = LocalViewModelOwner.current
    val vm: SurveyViewModel = viewModel(owner)

    val options = listOf(
        "Korean",
        "Chinese",
        "Japanese",
        "Southeast Asian (Thai / Vietnamese)",
        "Western (Italian / American)",
        "Mexican"
    )

    Column(Modifier.padding(24.dp)) {

        Text("What kind of country food do you like?", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        options.forEach { item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                val checked = vm.countryFoods.contains(item)
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        if (it) vm.countryFoods.add(item)
                        else vm.countryFoods.remove(item)
                    }
                )
                Text(item)
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("survey4") },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Next") }
    }
}
