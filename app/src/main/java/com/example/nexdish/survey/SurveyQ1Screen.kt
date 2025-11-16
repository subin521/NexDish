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
fun SurveyQ1Screen(navController: NavController) {

    val owner = LocalViewModelOwner.current
    val vm: SurveyViewModel = viewModel(owner)

    val options = listOf(
        "Rice / Noodles / Tteok",
        "Meat dishes",
        "Fish / Seafood dishes",
        "Vegetables / Salads / Namul",
        "Bread / Pasta / Pizza",
        "Desserts / Snacks"
    )

    Column(Modifier.padding(24.dp)) {

        Text("What kind of food do you enjoy eating?", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text("You can choose more than one")

        Spacer(Modifier.height(24.dp))

        options.forEach { item ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                val checked = vm.foodTypes.contains(item)
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        if (it) vm.foodTypes.add(item)
                        else vm.foodTypes.remove(item)
                    }
                )
                Text(item)
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("survey2") },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Next") }
    }
}
