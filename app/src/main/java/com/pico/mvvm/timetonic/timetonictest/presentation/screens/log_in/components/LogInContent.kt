package com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.LogInScreen
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Red500
import com.pico.mvvm.timetonic.timetonictest.R
import com.pico.mvvm.timetonic.timetonictest.presentation.components.DefaultButton
import com.pico.mvvm.timetonic.timetonictest.presentation.components.DefaultTextField
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Darkgray700
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Orange
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Red700

@Composable
fun LogInContent(){

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier =  Modifier.padding(start = 30.dp, end = 30.dp, top = 50.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp, end = 0.dp)
                ,text = "LOGIN"
                , fontSize = 18.sp
                , fontWeight = FontWeight.Bold
                , color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Por favor inicia sesion para continuar"
                , fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextField(
                value = "",
                modifier =  Modifier.padding(top = 10.dp),
                onValueChange ={}
                , label = "Correo electronico"
                , icon = Icons.Default.Email
                , keyBoardType =  KeyboardType.Email
                , errorMsg =  ""
                , validateField = {})
            DefaultTextField(
                value = "",
                modifier =  Modifier.padding(top = 10.dp),
                onValueChange ={}
                , label = "Contraseña"
                , icon = Icons.Default.Lock
                , keyBoardType =  KeyboardType.Email
                , errorMsg =  ""
                , validateField = {})
            DefaultButton(text = "INICIAR SESION",
                onClick = {},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp))
            Text(
                modifier = Modifier.alpha(0f),
                text = "",
                fontSize =  11.sp,
                color = Red700,
            )
        }


        }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LogInContent()
}