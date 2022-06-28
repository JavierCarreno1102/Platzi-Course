package com.sarah.testlessor.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sarah.testlessor.ui.components.Country
import com.sarah.testlessor.ui.components.ProducCard
import com.sarah.testlessor.ui.navigation.AppScreens
import com.sarah.testlessor.ui.scrips.Product
import com.sarah.testlessor.ui.theme.TestLessorTheme


@Composable
fun FeedScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.secondary) {
            Spacer(modifier = Modifier.width(16.dp))

            Text("Principal", color = Color.White, style = MaterialTheme.typography.h5)


        }


    }) {
        BodyFeedScreen(navController = navController)

    }
}

@Composable
fun BodyFeedScreen(navController: NavController) {
    var countryList = listOf<Country>(Country.COL, Country.BRA, Country.CRI, Country.NIC)

    ShowTitle("HolaMundo", MaterialTheme.colors.onBackground)
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                ShowTitle("Los Mejores Cafes ", MaterialTheme.colors.onBackground)
            }
            items(countryList) { country ->
                ProducCard(
                    Product(
                        "Cafe ${country.getCountryName()}",
                        "El mejor cafe del mundo",
                        50
                    ), country
                ) {
                    navController.navigate(AppScreens.DetailScreen.route + "/${country.getCountryName()}" + "/${country.getFlag()}") {
                        launchSingleTop = true
                    }

                }

            }

        }
    }

//                CreateText("HolaMundo", MaterialTheme.colors.onBackground)

}

@Composable
fun ShowTitle(text: String, color: Color) {
    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 15.dp, bottom = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Text(text, color = color, style = MaterialTheme.typography.h4)
    }

}

//@Preview(showBackground = true)
////@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun Preview() {
////    TestLessorTheme {
////        val navController= rememberNavController()
////        FeedScreen(navController)
////    }
//}