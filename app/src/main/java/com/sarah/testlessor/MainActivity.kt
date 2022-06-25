package com.sarah.testlessor

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sarah.testlessor.ui.components.Country
import com.sarah.testlessor.ui.components.ProducCard
import com.sarah.testlessor.ui.navigation.AppNavegation
import com.sarah.testlessor.ui.screens.DetailScreen
import com.sarah.testlessor.ui.screens.FeedScreen
import com.sarah.testlessor.ui.scrips.Product

import com.sarah.testlessor.ui.theme.TestLessorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var countryList= listOf<Country>(Country.COL,Country.BRA,Country.CRI,Country.NIC)

        setContent { AppNavegation()}
    }
}





