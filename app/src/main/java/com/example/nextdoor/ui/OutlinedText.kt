package com.example.nextdoor.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedText(
    @StringRes resId: Int,
    textStyle: TextStyle,
    fillColor: Color,
    borderColor: Color,
    strokeWidth: Float
) {
    OutlinedText(stringResource(resId), textStyle, fillColor, borderColor, strokeWidth)
}

@Composable
fun OutlinedText(
    text: String,
    textStyle: TextStyle,
    fillColor: Color,
    borderColor: Color,
    strokeWidth: Float
) {
    Box {
        // Border
        Text(
            text,
            style = textStyle.copy(
                color = borderColor,
                drawStyle = Stroke(width = strokeWidth),
            ),
        )

        // Fill
        Text(
            text,
            color = fillColor,
            style = textStyle,
        )
    }
}

@Suppress("unused")
class OutlinedTextPreviews {
    @Preview
    @Composable
    private fun OutlinedTextLargePreview() {
        OutlinedText(
            text = "Hogemoge",
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 48.sp,
                fontWeight = FontWeight.W700,
            ),
            fillColor = Color.White,
            borderColor = Color.Black,
            strokeWidth = 5f,
        )
    }

    @Preview
    @Composable
    private fun OutlinedTextSmallPreview() {
        OutlinedText(
            text = "ポイント 10,000pt",
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
            ),
            fillColor = Color.Black,
            borderColor = Color.White,
            strokeWidth = 20f,
        )
    }
}
