package com.example.parcial.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.ui.theme.Green900
import com.example.parcial.ui.theme.Red900

@Composable
fun DetalleFila (
    fecha: String, descripcion: String, monto: Double, autorizacion: String, modifier: Modifier
) {

// @TODO AUGUSTO: cambiar el font family.
    val textColor = if (monto > 0) Green900 else Red900
    val formattedMonto = if (monto > 0) "+$%.2f".format(monto) else "$%.2f".format(monto)

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 19.6.sp,
        textAlign = TextAlign.Left
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .sizeIn(minWidth = 360.dp, minHeight = 56.dp)
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(1.dp)
            )
            .padding(top = 8.dp, end = 12.dp, bottom = 8.dp, start = 12.dp),
    ) {
        Text(
            text = fecha, style = customTextStyle, color = Color.Black
        )
        Spacer(modifier = Modifier.weight(0.05f))
        Column {
            Text(
                text = descripcion,
                style = customTextStyle,
            )
            Text(
                text = autorizacion,
                style = customTextStyle,
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Text(
            text = formattedMonto,
            style = customTextStyle,
            color = textColor,
        )
    }
}