package com.sarah.testlessor.ui.components

import android.content.res.Configuration
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sarah.testlessor.R
import com.sarah.testlessor.ui.theme.PlatziBlue
import com.sarah.testlessor.ui.theme.TestLessorTheme
import com.sarah.testlessor.ui.scrips.Product
import com.sarah.testlessor.ui.theme.PlatziGreen

enum class Country(var iso:String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");


    fun getCountryName():String{
        return when(this){
            COL-> "Colombia"
            BRA-> "Brazil"
            CRI-> "Costa Rica"
            NIC-> "Nicaragua"

        }
    }

    fun getBackground():Int{
        return when(this){
            COL-> R.drawable.co
            BRA-> R.drawable.br
            CRI-> R.drawable.ri
            NIC-> R.drawable.ni

        }
    }

    fun getFlag():Int{
        return when(this){
            COL-> R.drawable.flagco
            BRA-> R.drawable.flagbr
            CRI-> R.drawable.flagri
            NIC-> R.drawable.flagni

        }
    }

    fun getColor():Color{
        return when(this){
            COL,BRA-> PlatziBlue
            CRI,NIC-> PlatziGreen
        }
    }



}

typealias  SelectionAction=()->Unit
@Composable
fun ProducCard(product: Product,country: Country,selected:SelectionAction) {

    TestLessorTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    selected()
                }
                .size(480.dp)
                .background(Color.Black),
            elevation = 10.dp,
            shape = MaterialTheme.shapes.large

        ) {
            Image(
                painter = painterResource(id = country.getBackground()),
                null,
                modifier = Modifier.fillMaxHeight()
            )
            Surface(


                modifier = Modifier.fillMaxHeight(),
                color = country.getColor().copy(alpha = 0.2f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(product.name, style = MaterialTheme.typography.h5)
                    Text(product.description, style = MaterialTheme.typography.h5)

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Bottom,

                        ) {
                        Row {
                            Image(
                                painter = painterResource(id = country.getFlag()),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp, 50.dp)
                                    .padding(start = 10.dp, bottom = 10.dp)
                            )

                            Text(
                                "$${product.price} USD",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 10.dp),
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.h4,
                                color = MaterialTheme.colors.onBackground

                            )
                        }

                    }
                }

            }
        }
    }

}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ProducPreview() {
    Column() {
        ProducCard(Product("Cafe de Costa Rica", "El mejor cafe del mundo", 50),Country.CRI){}

    }

}