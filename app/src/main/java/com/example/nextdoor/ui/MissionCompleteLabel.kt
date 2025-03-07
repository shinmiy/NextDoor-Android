package com.example.nextdoor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.nextdoor.R

@Composable
fun MissionCompleteLabel() {
    OutlinedText(
        text = "Mission Complete",
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

@Composable
fun PointsLabel(points: Int) {
    OutlinedText(
        text = stringResource(R.string.points_label, points),
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.W700,
        ),
        fillColor = Color.Black,
        borderColor = Color.White,
        strokeWidth = 10f,
    )
}

@Suppress("unused")
class LabelPreviews {
    @Preview
    @Composable
    private fun MissionCompleteLabelPreview() {
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            MissionCompleteLabel()
        }
    }

    @Preview
    @Composable
    private fun PointsLabelPreview() {
        Box(
            modifier = Modifier.background(Color.Blue)
        ) {
            PointsLabel(10_000)
        }
    }
}
