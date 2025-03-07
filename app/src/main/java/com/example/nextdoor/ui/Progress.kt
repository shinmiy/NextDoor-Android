package com.example.nextdoor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nextdoor.R
import java.text.NumberFormat

@Composable
fun Progress(
    progress: Float,
) {
    val progressText = NumberFormat.getPercentInstance().format(progress)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp),
    ) {
        // background
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(Int.MAX_VALUE.dp))
            .height(24.dp)) {
            Text(
                progressText,
                modifier = Modifier.align(Alignment.Center),
            )
        }

        // foreground
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(
                GenericShape { size, _ ->
                    moveTo(0f, 0f)
                    lineTo(size.width * progress, 0f)
                    lineTo(size.width * progress, size.height)
                    lineTo(0f, size.height)
                    close()
                }
            )
            .background(Color.Green, shape = RoundedCornerShape(Int.MAX_VALUE.dp))
            .height(24.dp)) {
            Text(
                progressText,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Suppress("unused")
class ProgressPreviews {
    @Preview
    @Composable
    fun ProgressFullPreview() {
        Progress(progress = 1f)
    }

    @Preview
    @Composable
    fun ProgressHalfPreview() {
        Progress(progress = 0.5f)
    }

    @Preview
    @Composable
    fun ProgressEmptyPreview() {
        Progress(progress = 0f)
    }
}
