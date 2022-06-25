package com.sarah.testlessor.ui.navigation

sealed class AppScreens(val route:String){
    object FeedScreen:AppScreens("feedScreen")
    object DetailScreen:AppScreens("detailScreen")
}
