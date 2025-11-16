package com.example.nexdish.survey

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nexdish.LocalViewModelOwner
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun SurveyQ4Screen(navController: NavController) {

    val owner = LocalViewModelOwner.current
    val vm: SurveyViewModel = viewModel(owner)

    val options = listOf("Spicy", "Sweet", "Sour", "Umami", "Salty", "Nutty / Savory")

    Column(modifier = Modifier.padding(24.dp)) {

        Text("Which taste do you prefer?", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        FlowRow {
            options.forEach { item ->
                val selected = vm.tastes.contains(item)
                AssistChip(
                    onClick = {
                        if (selected) vm.tastes.remove(item)
                        else vm.tastes.add(item)
                    },
                    label = { Text(item) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                        labelColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                    )
                )

                Spacer(Modifier.width(8.dp))
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                vm.saveSurvey()
                navController.navigate("home")  // 저장 후 홈 또는 추천 화면
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Next") }
    }
}
