package com.example.nexdish.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeTabSection(
    selected: HomeTab,
    onSelect: (HomeTab) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = selected == HomeTab.Main,
            onClick = { onSelect(HomeTab.Main) },
            label = { Text("Main") }
        )
        FilterChip(
            selected = selected == HomeTab.ForYou,
            onClick = { onSelect(HomeTab.ForYou) },
            label = { Text("For you") }
        )
        FilterChip(
            selected = selected == HomeTab.NewToday,
            onClick = { onSelect(HomeTab.NewToday) },
            label = { Text("New Today") }
        )
    }
}