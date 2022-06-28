package com.sarah.testlessor.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Alert(title: String, message: String?, onClose: () -> Unit):Int{
    var tempInt by remember{ mutableStateOf(10) }
    if (message != null) {
        AlertDialog(onDismissRequest = { onClose() },
            title = {

                Box(modifier = Modifier.padding(bottom = 16.dp)){
                    Text(
                        text = title,
                        color = Color.Black,
                        style = MaterialTheme.typography.h5
                    )

                }


            },
            text = {
                Text(
                    text = message,
                    color = Color.Black,
                    style = MaterialTheme.typography.h5
                )
            },
            confirmButton = {

//                Button(onClick = { onClose()}) {
//                    Text(text = "OK", color = Color.Black,style = MaterialTheme.typography.h5)
//                }
                Box(modifier = Modifier.padding(all = 16.dp)){
                    CustomButton(label = "OK") {
                        onClose()
                        tempInt++
                    }
                }

            }

        )
    }

    return tempInt


}