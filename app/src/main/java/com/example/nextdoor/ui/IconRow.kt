package com.example.nextdoor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nextdoor.R

@Composable
fun IconRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        TransparentRoundIcon(
            type = Type.Run,
            iconColor = Color.Red,
            modifier = Modifier
                .size(24.dp)
                .rotate(-30f)
                .align(Alignment.Bottom),
        )

        TransparentRoundIcon(
            type = Type.Paraglider,
            iconColor = Color.Blue,
            modifier = Modifier
                .size(24.dp)
                .rotate(30f)
                .align(Alignment.CenterVertically),
        )

        Column(
            modifier = Modifier.align(Alignment.CenterVertically),
        ) {
            TransparentRoundIcon(
                type = Type.Bike,
                iconColor = Color.Yellow,
                modifier = Modifier
                    .size(24.dp)
                    .rotate(-15f),
            )
            Spacer(modifier = Modifier.height(4.dp))
            PointsLabel(points = 10_000)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconRowPreview() {
    Box(modifier = Modifier.background(color = Color.hsv(218f, 1f, 1f))) {
        IconRow()
    }
}
