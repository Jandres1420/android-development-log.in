package com.pico.mvvm.timetonic.timetonictest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Red500
import com.pico.mvvm.timetonic.timetonictest.ui.theme.Red700

@Composable
fun DefaultButton(text: String,
                  onClick: () -> Unit,
                  color: Color = Red500,
                  icon: ImageVector = Icons.Default.ArrowForward,
                  modifier: Modifier,
                  errorMsg: String = "",
                  enabled: Boolean = true){
    Column() {

        Button(
            modifier = modifier.background(color , shape = MaterialTheme.shapes.small),
            onClick = { onClick()},
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(backgroundColor = color)
        ) {
            Icon(imageVector = icon,
                contentDescription = "", tint = Color.Black)
            Text(text = "$text",color = Color.Black)
        }
        Text(modifier = Modifier.padding(top = 5.dp),
            text = errorMsg,
            fontSize =  11.sp,
            color = Red700
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultButtonPreview() {
    DefaultButton(text = "INICIAR SESION",
        onClick ={ },
        enabled =  true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 70.dp))
}