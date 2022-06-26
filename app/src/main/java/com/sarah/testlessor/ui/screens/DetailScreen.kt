package com.sarah.testlessor.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sarah.testlessor.ui.components.*
import com.sarah.testlessor.ui.theme.TestLessorTheme

@Composable
fun DetailScreen(navController: NavController, text: String?,flag:Int?) {

    var increase by remember{ mutableStateOf(0)}
    var fieldValue by remember{ mutableStateOf("")}

    Scaffold(topBar = {
        TopAppBar() {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier.clickable { navController.popBackStack() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Secundary", color = MaterialTheme.colors.onBackground)
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

//            for (i in 1..5) {
//                if (text != null) {
//                    Text(
//                        text,
//                        modifier = Modifier.padding(15.dp),
//                        style = MaterialTheme.typography.h4
//                    )
//                }
//            }


            text?.let {
                Text(
                    it.uppercase(),
                    modifier = Modifier.padding(15.dp).padding(top = 16.dp),
                    style = MaterialTheme.typography.h4,
                    color=MaterialTheme.colors.onBackground
                )
                flag.let {
                    Image(
                        painter = painterResource(id = it!!),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp, 50.dp)
                            .padding(top = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start=16.dp,end=16.dp) ){
                CustomButton("Increase".uppercase()) { increase=test(25,30)}
            }

            Spacer(modifier = Modifier.padding(16.dp))
            Text("Valor $increase",color = MaterialTheme.colors.onBackground)
            fieldValue=DropDown2(cities, "Data Entry")
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start=16.dp,end=16.dp) ){
               CustomTextField(value = fieldValue, placeHolder = "Data") {}
            }
            Text("Valor $fieldValue", color = MaterialTheme.colors.onBackground)





        }
    }


}

fun test(test1:Int,test2:Int):Int{

    return test1+test2
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {

    TestLessorTheme {
        val navController= rememberNavController()
        DetailScreen(navController,"Colombia",Country.COL.getFlag())
    }
}

