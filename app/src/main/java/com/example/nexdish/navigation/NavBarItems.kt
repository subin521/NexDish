package com.example.nexdish.navigation

import com.example.nexdish.R

sealed class NavBarItem(
    val route: String,
    val title: String,
    val icon: Int,
    val selectedIcon: Int
) {
    object Home : NavBarItem(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home_unselected, //아이콘 집어넣어야함 11/16
        selectedIcon = R.drawable.ic_home_selected
    )

    object Calendar : NavBarItem(
        route = "calendar",
        title = "Calendar",
        icon = R.drawable.ic_calendar_unselected,
        selectedIcon = R.drawable.ic_calendar_selected
    )

    object Profile : NavBarItem(
        route = "profile",
        title = "My",
        icon = R.drawable.ic_user_unselected,
        selectedIcon = R.drawable.ic_user_selected
    )

    companion object {
        val BarItems = listOf(Home, Calendar, Profile)
    }
}
