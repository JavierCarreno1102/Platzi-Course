package com.sarah.testlessor.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.sarah.testlessor.ui.navigation.AppScreens
import com.sarah.testlessor.ui.screens.ShowTitle
import com.sarah.testlessor.ui.scrips.Product
import com.sarah.testlessor.ui.theme.TestLessorTheme
import com.sarah.testlessor.ui.theme.backgrounWhite


//------------------------Button-------------------------------------------------
@Composable
fun CustomButton(label: String, clic: () -> Unit) {
    Button(
        onClick = { clic() },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primaryVariant
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = label, style = MaterialTheme.typography.h4, color = Color.White)
    }
}

//------------------------Button-------------------------------------------------
//------------------------textField-------------------------------------------------
@Composable
fun CustomTextField(
    value: String,
    placeHolder: String,
    enable: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null,
    onGlobalposition: ((LayoutCoordinates) -> Unit)? = null,
    onValueChange: (String) -> Unit
) {

    var focusManager = LocalFocusManager.current


    OutlinedTextField(

        value =value,
        onValueChange = onValueChange,
        textStyle = TextStyle(color = Color.Black),
        label = {
            Text(
                text = placeHolder,
                style = MaterialTheme.typography.caption,
                color = Color.Red
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { cordinates ->

                if (onGlobalposition != null) {
                    onGlobalposition(cordinates)
                }
            },
        enabled = enable,
        keyboardActions = KeyboardActions(

            onDone = { focusManager.clearFocus() }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        trailingIcon = trailingIcon,
        colors = TextFieldDefaults.outlinedTextFieldColors(Color.White)


    )
}

//------------------------textField-------------------------------------------------
//------------------------DropDown-------------------------------------------------
@Composable
fun DropDown(
    options: List<String>,
    value: String,
    placeHolder: String,
    onChangeValue: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }

    var icon = Icons.Filled.ArrowDropDown

    Column() {
        CustomTextField(
            value = value,
            placeHolder = placeHolder,
            onValueChange = onChangeValue,
            enable = false,
            trailingIcon = {
                Icon(icon,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }, tint = Color.Red
                )
            },
            onGlobalposition = { coordinate ->
                textFieldSize = coordinate.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) {
                textFieldSize.width.toDp()
            })
        ) {
            options.forEach {
                DropdownMenuItem(onClick = {
                    onChangeValue(it)
                    expanded = !expanded

                }) {
                    Text(it,
                        style = MaterialTheme.typography.h5,
                        color = Color.Red)
                }

            }


        }

    }

}


val cities = listOf(
    "Aberdeen",
    "Abilene",
    "Akron",
    "Albany",
    "Albuquerque",
    "Alexandria",
    "Allentown",
    "Amarillo",
    "Anaheim",
    "Anchorage"
)


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ComponsablePreviews() {
    TestLessorTheme {
        //CustomButton(label = "TEST") {}
        CustomTextField(value = "Test3", placeHolder = "data entry") {}


//        DropDown(cities, "", "Data Entry") {}


    }
}
