package com.sarah.testlessor.ui.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sarah.testlessor.ui.screens.DetailScreen
import com.sarah.testlessor.ui.screens.FeedScreen
import com.sarah.testlessor.ui.theme.TestLessorTheme


@Composable
fun AppNavegation() {

    val navController = rememberNavController()
    TestLessorTheme {
        NavHost(navController = navController, startDestination = AppScreens.FeedScreen.route) {
            composable(route = AppScreens.FeedScreen.route) {
                FeedScreen(navController)
            }
            composable(route = AppScreens.DetailScreen.route + "/{text}/{flag}",
                arguments = listOf(
                    navArgument(name = "text") { type = NavType.StringType },
                    navArgument(name = "flag") { type = NavType.IntType }


                )
            ) {
                DetailScreen(
                    navController,
                    it.arguments?.getString("text"),
                    it.arguments?.getInt("flag")
                )
            }

        }
    }

}