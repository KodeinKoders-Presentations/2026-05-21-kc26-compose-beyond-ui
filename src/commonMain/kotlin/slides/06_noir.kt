package slides

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.theme.cup.ui.KodeinAnimatedVisibility
import net.kodein.theme.cup.ui.KodeinFadeAnimatedVisibility
import org.jetbrains.compose.resources.imageResource
import compose_beyond_ui.generated.resources.Res
import compose_beyond_ui.generated.resources.noir_mc_back
import compose_beyond_ui.generated.resources.noir_mc_front
import compose_beyond_ui.generated.resources.noir_slanted_page_back
import compose_beyond_ui.generated.resources.noir_slanted_page_front
import compose_beyond_ui.generated.resources.noir_straight_page_back


val noir by Slide(
    stepCount = 8
) { step ->
    Row {
        Text(
            text = "The Noir ",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        KodeinAnimatedVisibility(step < 6) {
            Text(
                text = "problem",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }
        KodeinAnimatedVisibility(step >= 6) {
            Text(
                text = "solution!",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }
    }

    KodeinAnimatedVisibility(step == 0) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Image(
                bitmap = imageResource(Res.drawable.noir_mc_front),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(184.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
            Image(
                bitmap = imageResource(Res.drawable.noir_mc_back),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(184.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
        }
    }

    KodeinAnimatedVisibility(step >= 1) {
        Box {
            val rotation by animateFloatAsState(if (step >= 4) 180f else 0f, tween(1500))
            val fScale by animateFloatAsState(if (step >= 3) 1.5f else 1f, tween(1000))
            val cutW = 0.425f
            val cutH = 0.419f
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 0f)
                        scaleX = fScale
                        scaleY = fScale
                    }
                    .graphicsLayer {
                        compositingStrategy = CompositingStrategy.Offscreen
                        rotationY = rotation
                        cameraDistance = 4.dp.toPx()
                        alpha = if (rotation > 90) 0f else 1f
                    }
            ) {
                val cutX = 0.075f
                val cutY = 0.081f
                val a by animateFloatAsState(if (step >= 2) 1f else 0f, tween(1000))
                Image(
                    bitmap = imageResource(Res.drawable.noir_slanted_page_front),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .height(256.dp)
                        .background(Color.Cyan)
                        .drawWithContent {
                            drawContent()
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(cutX * size.width, 0f),
                                end = Offset(cutX * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset((cutX + cutW) * size.width, 0f),
                                end = Offset((cutX + cutW) * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset((cutX + cutW * 2) * size.width, 0f),
                                end = Offset((cutX + cutW * 2) * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, cutY * size.height),
                                end = Offset(size.width, cutY * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, (cutY + cutH) * size.height),
                                end = Offset(size.width, (cutY + cutH) * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, (cutY + cutH * 2) * size.height),
                                end = Offset(size.width, (cutY + cutH * 2) * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                )
                val x by animateFloatAsState(if (step >= 3) 0.075f else 0f, tween(1000))
                val y by animateFloatAsState(if (step >= 3) 0.081f else 0f, tween(1000))
                val w by animateFloatAsState(if (step >= 3) cutW else 1f, tween(1000))
                val h by animateFloatAsState(if (step >= 3) cutH else 1f, tween(1000))
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .graphicsLayer { blendMode = BlendMode.DstIn }
                        .drawBehind {
                            drawRect(
                                color = Color.Black,
                                topLeft = Offset(size.width * x, size.height * y),
                                size = Size(size.width * w, size.height * h)
                            )
                        }
                )
            }

            val bScale by animateFloatAsState(if (step !in 5..<7) 1.5f else 1f, tween(1000))
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        transformOrigin = TransformOrigin(0.5f, 0f)
                        scaleX = bScale
                        scaleY = bScale
                    }
                    .graphicsLayer {
                        compositingStrategy = CompositingStrategy.Offscreen
                        rotationY = 180f + rotation
                        cameraDistance = 4.dp.toPx()
                        alpha = if (rotation <= 90) 0f else 1f
                    }
            ) {
                val cutX = 0.486f
                val cutY = 0.087f
                val a= 1f
                Box(
                    modifier = Modifier
                        .drawWithContent {
                            drawContent()
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(cutX * size.width, 0f),
                                end = Offset(cutX * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset((cutX + cutW) * size.width, 0f),
                                end = Offset((cutX + cutW) * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset((cutX - cutW) * size.width, 0f),
                                end = Offset((cutX - cutW) * size.width, size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, cutY * size.height),
                                end = Offset(size.width, cutY * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, (cutY + cutH) * size.height),
                                end = Offset(size.width, (cutY + cutH) * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                            drawLine(
                                color = Color.Gray.copy(alpha = a),
                                start = Offset(0f, (cutY + cutH * 2) * size.height),
                                end = Offset(size.width, (cutY + cutH * 2) * size.height),
                                strokeWidth = 1.dp.toPx()
                            )
                        }
                ) {
                    Image(
                        bitmap = imageResource(Res.drawable.noir_slanted_page_back),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .height(256.dp)
                    )
                    KodeinFadeAnimatedVisibility(
                        visible = step >= 6,
                        durationMillis = 1500,
                    ) {
                        Image(
                            bitmap = imageResource(Res.drawable.noir_straight_page_back),
                            contentDescription = null,
                            contentScale = ContentScale.FillHeight,
                            modifier = Modifier
                                .height(256.dp)
                        )
                    }
                }
                val x by animateFloatAsState(if (step !in 5..<7) cutX else 0f, tween(1000))
                val y by animateFloatAsState(if (step !in 5..<7) cutY else 0f, tween(1000))
                val w by animateFloatAsState(if (step !in 5..<7) cutW else 1f, tween(1000))
                val h by animateFloatAsState(if (step !in 5..<7) cutH else 1f, tween(1000))
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .graphicsLayer { blendMode = BlendMode.DstIn }
                        .drawBehind {
                            drawRect(
                                color = Color.Black,
                                topLeft = Offset(size.width * x, size.height * y),
                                size = Size(size.width * w, size.height * h)
                            )
                        }
                )
            }
        }
    }
}