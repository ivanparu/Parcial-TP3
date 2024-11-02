package com.example.parcial.ui.components

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R


@Composable
fun BotonClick(
    texto: String
) {

    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )

    val typography = Typography(
        bodyLarge = TextStyle(
            fontFamily = manropeBold,
            fontSize = 16.sp,
            lineHeight = 19.6.sp
        )
    )

    Row(
        modifier = Modifier
            .width(336.dp)
            .height(70.dp)
            .padding(top = 16.dp, end = 12.dp, start = 12.dp, bottom = 16.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(5.dp)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = texto,
            style = typography.bodyLarge,
            modifier = Modifier
                .padding(start = 12.dp)

        )
        Image(
            painter = painterResource(id = R.drawable.flecha_boton),
            contentDescription = "Icono del botón",
            modifier = Modifier
                .width(32.dp)
                .height(30.dp)
                .padding(end = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BotonClickPreview() {
    BotonClick("Mis datos")
}

