package com.example.nextdoor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nextdoor.ui.BackgroundComponents.Ground
import com.example.nextdoor.ui.BackgroundComponents.Sky

@Composable
fun Background() {
    Column(
        modifier = Modifier.background(Color.White),
    ) {
        Sky(Modifier.weight(1f))
        Ground()
    }
}

private object BackgroundComponents {
    @Composable
    fun Sky(
        modifier: Modifier = Modifier,
    ) {
        Column(modifier = modifier) {
            repeat(10) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(
                            Color.hsv(
                                hue = 218f,
                                saturation = 1f - index / 10f,
                                value = 1f,
                            ),
                        ),
                )
            }
        }
    }

    @Composable
    fun Ground() {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((4+ 4 * index).dp)
                        .background(Color(0xFFB36624))
                )
            }
        }
    }
}

@Preview
@Composable
private fun BackgroundPreview() {
    Background()
}
