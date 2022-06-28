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
import androidx.compose.ui.graphics.Color
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
    var message by remember{ mutableStateOf<String?>(null)}
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.secondary) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier.clickable { navController.popBackStack() },
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Secundary", color = Color.White,style = MaterialTheme.typography.h5)
        }
    }, content =  {
        increase=Alert(title ="Felicidades" , message =message ) {
            message=null
        }
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
                    modifier = Modifier
                        .padding(15.dp)
                        .padding(top = 16.dp),
                    style = MaterialTheme.typography.h4,
                    color=MaterialTheme.colors.onBackground
                )
                flag.let {
                    Image(
                        painter = painterResource(id = it!!),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp, 100.dp)
                            .padding(top = 16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.padding(16.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp) ){
//                CustomButton("Increase".uppercase()) { increase=test(25,30)}
                CustomButton("Increase".uppercase()) { message="el celular va a explotar"}
            }

            Spacer(modifier = Modifier.padding(16.dp))
            Text("Valor $increase",color = MaterialTheme.colors.onBackground, style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.padding(16.dp))
            fieldValue=DropDown2(cities, "Data Entry")
            Spacer(modifier = Modifier.padding(16.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp) ){
               CustomTextField(value = fieldValue, placeHolder = "Data") {}
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text("Nuevo Con Windows $fieldValue", color = MaterialTheme.colors.onBackground)





        }
    })


}
var externalIncrease=0
fun test(test1:Int,test2:Int):Int{

    externalIncrease+=test1
    return externalIncrease+test2
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {

    TestLessorTheme {
        val navController= rememberNavController()
        DetailScreen(navController,"Colombia",Country.COL.getFlag())
    }
}

