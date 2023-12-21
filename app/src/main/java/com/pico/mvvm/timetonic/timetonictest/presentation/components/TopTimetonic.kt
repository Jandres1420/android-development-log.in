package com.pico.mvvm.timetonic.timetonictest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pico.mvvm.timetonic.timetonictest.R
import com.pico.mvvm.timetonic.timetonictest.presentation.screens.log_in.LogInScreen
import com.pico.mvvm.timetonic.timetonictest.ui.theme.BlueTitle
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Orange

@Composable
fun TopTimetonic() {

    Box(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.tertiary,),
    )  {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,)  {
                Image(modifier = Modifier.height(180.dp),
                    painter = painterResource(id = R.drawable.timetonic_logo)
                    , contentDescription = "Timetonic Logo")
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TopTimetonic()
}