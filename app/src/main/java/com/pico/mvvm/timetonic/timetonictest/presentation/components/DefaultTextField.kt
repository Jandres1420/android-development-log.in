package com.pico.mvvm.timetonic.timetonictest.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mvvm.gamermvvmapp.presentation.ui.theme.TimetonicTheme
import com.pico.mvvm.timetonic.timetonictest.ui.theme.BlueTitle

/**
 *  It makes an OutlinedTextField that can be reusable
 * @param value: String
 * @param modifier: Modifier
 * @param onValueChange: () -> {}
 * @param label: String
 * @param icon: ImageVector
 * @param keyBoardType: KeyBoardType
 * @param hideText: Boolean
 * @param errorMsg: String
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTextField(
    value: String,
    modifier: Modifier,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyBoardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false,
    errorMsg: String = ""
) {
    Column() {
        OutlinedTextField(modifier = modifier
            .height(65.dp)
            .width(300.dp),
            value = value,
            onValueChange = { myValue ->
                onValueChange(myValue)
            }, label = {
                Text(label)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyBoardType),
            leadingIcon = {
                Icon(
                    imageVector = icon, contentDescription = "",
                    tint = Color.White
                )
            },
            visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
        )
        Text(text = errorMsg, modifier.padding(top = 5.dp), fontSize = 11.sp, color = BlueTitle)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewDefaultButton() {
    TimetonicTheme {
        TimetonicTheme(darkTheme = false) {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background

            ) {
                DefaultTextField(label = "Email",
                    modifier = Modifier,
                    icon = Icons.Outlined.Add,
                    value = "",
                    onValueChange = {})
            }
        }
    }
}