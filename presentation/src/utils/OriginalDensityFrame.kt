package utils

import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import net.kodein.cup.LocalPresentationState
import net.kodein.cup.PluginCupAPI
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color

@OptIn(PluginCupAPI::class)
@Composable
fun OriginalDensityFrame(
    content: @Composable () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        var frameWidth by remember { mutableStateOf(384.dp) }
        var frameHeight by remember { mutableStateOf(288.dp) }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(frameWidth, frameHeight)
                .border(1.dp, Color(KodeinColors.light_orange), RoundedCornerShape(4.dp))
                .clip(RoundedCornerShape(4.dp))
        ) {
            Box(Modifier.padding(4.dp)) {
                CompositionLocalProvider(
                    LocalDensity provides LocalPresentationState.current.config.originalDensity()
                ) {
                    content()
                }
            }

            val density = LocalDensity.current
            Box(
                Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = (-4).dp)
                    .size(frameWidth, 8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeN)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameHeight -= (dragAmount.y * 2 / density.density).dp
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = 4.dp)
                    .size(8.dp, frameHeight)
                    .pointerHoverIcon(PointerIcon.ResizeW)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth += (dragAmount.x * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.BottomCenter)
                    .offset(y = 4.dp)
                    .size(frameWidth, 8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeN)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameHeight += (dragAmount.y * 2 / density.density).dp
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = (-4).dp)
                    .size(8.dp, frameHeight)
                    .pointerHoverIcon(PointerIcon.ResizeW)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth -= (dragAmount.x * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                        }
                    }
            )

            Box(
                Modifier
                    .align(Alignment.TopStart)
                    .offset((-4).dp, (-4).dp)
                    .size(8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeNW)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth -= (dragAmount.x * 2 / density.density).dp
                            frameHeight -= (dragAmount.y * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.TopEnd)
                    .offset(4.dp, (-4).dp)
                    .size(8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeNE)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth += (dragAmount.x * 2 / density.density).dp
                            frameHeight -= (dragAmount.y * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.BottomEnd)
                    .offset(4.dp, 4.dp)
                    .size(8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeSE)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth += (dragAmount.x * 2 / density.density).dp
                            frameHeight += (dragAmount.y * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
            Box(
                Modifier
                    .align(Alignment.BottomStart)
                    .offset((-4).dp, 4.dp)
                    .size(8.dp)
                    .pointerHoverIcon(PointerIcon.ResizeSW)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            frameWidth -= (dragAmount.x * 2 / density.density).dp
                            frameHeight += (dragAmount.y * 2 / density.density).dp
                            frameWidth = frameWidth.coerceAtLeast(8.dp)
                            frameHeight = frameHeight.coerceAtLeast(8.dp)
                        }
                    }
            )
        }
    }
}