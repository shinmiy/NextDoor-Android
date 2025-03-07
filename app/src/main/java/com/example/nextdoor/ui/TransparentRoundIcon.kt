package com.example.nextdoor.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser

enum class Type(val svgValue: String) {
    Paraglider(
        "m23,33.45q-1.57,0 -2.7,-1.12t-1.12,-2.7q0,-1.57 1.12,-2.7t2.7,-1.12q1.57,0 2.7,1.12t1.12,2.7q0,1.57 -1.12,2.7t-2.7,1.12zm-5.73,13.36l0,-6.87q-4.06,-1.38 -5.85,-4.7t-1.79,-7.52l3.82,0q0,4.82 2.43,7.18t7.11,2.36q4.68,0 7.11,-2.36t2.43,-7.18l3.82,0q0,4.2 -1.79,7.52t-5.85,4.7l0,6.87l-11.45,0zm-7.64,-21l-3.82,-8.97q-0.24,0.14 -0.81,0.5t-1.1,0.36q-0.81,0 -1.36,-0.55t-0.55,-1.36l0,-6.68q0,-3.39 6.16,-5.75t14.84,-2.36q8.69,0 14.84,2.36t6.16,5.75l0,6.68q0,0.81 -0.55,1.36t-1.36,0.55q-0.52,0 -1.1,-0.36t-0.81,-0.5l-3.82,8.97l-3.82,0l-2.86,-11.98q-1.57,-0.24 -3.25,-0.33t-3.44,-0.1q-1.77,0 -3.44,0.1t-3.25,0.33l-2.86,11.98l-3.82,0zm1.67,-3.34l1.96,-8.16q-1.34,0.29 -2.53,0.62t-2.29,0.76l2.86,6.78zm23.39,-0.05l2.86,-6.73q-1.1,-0.43 -2.29,-0.76t-2.53,-0.62l1.96,8.11zm-28.87,-9.83q3.39,-1.43 7.8,-2.22t9.38,-0.79q4.96,0 9.38,0.79t7.8,2.22l0,-3.39q-0.24,-0.48 -1.46,-1.22t-3.39,-1.46q-2.17,-0.72 -5.25,-1.22t-7.09,-0.5q-4.01,0 -7.09,0.5t-5.25,1.22q-2.17,0.72 -3.39,1.46t-1.46,1.22l0,3.39zm17.18,-7.78z",
    ),
    Run(
        "m22,45l0,-12l-4.2,-4l-2,8.8l-13.8,-2.8l0.8,-4l9.6,2l3.2,-16.2l-3.6,1.4l0,6.8l-4,0l0,-9.4l7.9,-3.4q1.75,-0.75 2.57,-0.97t1.52,-0.22q1.05,0 1.95,0.55t1.45,1.45l2,3.2q1.3,2.1 3.52,3.45t5.07,1.35l0,4q-3.3,0 -6.17,-1.37t-4.82,-3.62l-1.2,6l4.2,4l0,15l-4,0zm1,-35q-1.65,0 -2.82,-1.17t-1.17,-2.82q0,-1.65 1.17,-2.82t2.82,-1.17q1.65,0 2.82,1.17t1.17,2.82q0,1.65 -1.17,2.82t-2.82,1.17z"
    ),
    Bike(
        "m10.17,38.58q-3.8,0 -6.49,-2.68t-2.68,-6.49q0,-3.8 2.68,-6.49t6.49,-2.68q3.8,0 6.49,2.68t2.68,6.49q0,3.8 -2.68,6.49t-6.49,2.68zm0,-3.67q2.29,0 3.9,-1.6t1.6,-3.9q0,-2.29 -1.6,-3.9t-3.9,-1.6q-2.29,0 -3.9,1.6t-1.6,3.9q0,2.29 1.6,3.9t3.9,1.6zm11,-1.83l0,-9.17l-5.87,-5.13q-0.55,-0.5 -0.83,-1.17t-0.28,-1.4q0,-0.73 0.3,-1.4t0.8,-1.17l5.13,-5.13q0.55,-0.55 1.26,-0.83t1.49,-0.28q0.78,0 1.49,0.28t1.26,0.83l3.48,3.48q1.28,1.28 2.93,2.02t3.48,0.73l0,3.67q-2.61,0 -4.97,-1.01t-4.19,-2.84l-1.47,-1.47l-4.4,4.4l4.03,4.22l0,11.37l-3.67,0zm8.25,-24.75q-1.51,0 -2.59,-1.08t-1.08,-2.59q0,-1.51 1.08,-2.59t2.59,-1.08q1.51,0 2.59,1.08t1.08,2.59q0,1.51 -1.08,2.59t-2.59,1.08zm6.42,30.25q-3.8,0 -6.49,-2.68t-2.68,-6.49q0,-3.8 2.68,-6.49t6.49,-2.68q3.8,0 6.49,2.68t2.68,6.49q0,3.8 -2.68,6.49t-6.49,2.68zm0,-3.67q2.29,0 3.9,-1.6t1.6,-3.9q0,-2.29 -1.6,-3.9t-3.9,-1.6q-2.29,0 -3.9,1.6t-1.6,3.9q0,2.29 1.6,3.9t3.9,1.6z"
    ),
}

@Composable
fun TransparentRoundIcon(
    type: Type,
    iconColor: Color,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier.graphicsLayer(
            compositingStrategy = CompositingStrategy.Offscreen,
        ),
    ) {
        // Background
        drawOval(
            color = iconColor,
            topLeft = Offset.Zero,
            size = size,
        )

        // Image
        val path = PathParser
            .createPathFromPathData(type.svgValue)
            .asComposePath()
        drawPath(
            path = Path().apply {
                addPath(
                    path = path,
                    offset = Offset(10f, 10f)
                )
            },
            color = Color.White,
            blendMode = BlendMode.Clear,
        )
    }
}

@Suppress("unused")
class RoundIconPreviews {
    @Preview
    @Composable
    private fun RoundIconRunPreview() {
        Box(modifier = Modifier.background(Color.LightGray)) {
            TransparentRoundIcon(
                type = Type.Run,
                iconColor = Color.Red,
                modifier = Modifier.size(100.dp),
            )
        }
    }

    @Preview
    @Composable
    private fun RoundIconParaglidingPreview() {
        Box(modifier = Modifier.background(Color.LightGray)) {
            TransparentRoundIcon(
                type = Type.Paraglider,
                iconColor = Color.Blue,
                modifier = Modifier.size(100.dp)
            )
        }
    }

    @Preview
    @Composable
    private fun RoundIconBikePreview() {
        Box(modifier = Modifier.background(Color.LightGray)) {
            TransparentRoundIcon(
                type = Type.Bike,
                iconColor = Color.Yellow,
                modifier = Modifier.size(100.dp),
            )
        }
    }
}
