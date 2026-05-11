package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.qrose.options.QrBallShape
import io.github.alexzhirkevich.qrose.options.QrBrush
import io.github.alexzhirkevich.qrose.options.QrColors
import io.github.alexzhirkevich.qrose.options.QrFrameShape
import io.github.alexzhirkevich.qrose.options.QrPixelShape
import io.github.alexzhirkevich.qrose.options.QrShapes
import io.github.alexzhirkevich.qrose.options.circle
import io.github.alexzhirkevich.qrose.options.roundCorners
import io.github.alexzhirkevich.qrose.options.solid
import io.github.alexzhirkevich.qrose.rememberQrCodePainter
import net.kodein.cup.Slide
import net.kodein.cup.widgets.material3.BulletPoints
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.ui.KodeinAnimatedVisibility
import org.jetbrains.compose.resources.imageResource
import compose_beyond_ui.generated.resources.Res
import compose_beyond_ui.generated.resources.cup


val cup by Slide(
    stepCount = 4
) { step ->

    AnimatedVisibility(
        visible = step >= 1,
        enter = fadeIn(tween(1500)) + expandVertically(tween(1500), clip = false),
        exit = fadeOut(tween(1500)) + shrinkVertically(tween(1500), clip = false),
    ) {
        Image(
            bitmap = imageResource(Res.drawable.cup),
            contentDescription = "CuP logo",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clip(CircleShape)
                .size(96.dp)
        )
    }

    ProvideTextStyle(
        MaterialTheme.typography.displayLarge
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("C")
            RSAV(step <= 1) {
                Text("ompose ")
                RSAV(step == 0) {
                    Text("yo")
                }
            }
            Text("u")
            RSAV(step <= 1) {
                Text("r ")
            }
            Text("P")
            RSAV(step <= 1) {
                Text("res")
                RSAV(step == 0) {
                    Text("entations")
                }
            }
        }
    }

    AnimatedVisibility(
        visible = step >= 2,
        enter = fadeIn(tween(1500)) + expandVertically(tween(1500)),
        exit = fadeOut(tween(1500)) + shrinkVertically(tween(1500)),
    ) {
        Link(
            text = "https://github.com/KodeinKoders/CuP",
            uri = "https://github.com/KodeinKoders/CuP",
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
    AnimatedVisibility(
        visible = step >= 2,
        enter = fadeIn(tween(1500)) + expandVertically(tween(1500)),
        exit = fadeOut(tween(1500)) + shrinkVertically(tween(1500)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(152.dp)
        ) {
            Image(
                painter = rememberQrCodePainter(
                    "https://github.com/KodeinKoders/CuP",
                    shapes = QrShapes(
                        ball = QrBallShape.roundCorners(.25f),
                        frame = QrFrameShape.roundCorners(.25f),
                        darkPixel = QrPixelShape.circle(),
                    ),
                    colors = QrColors(
                        dark = QrBrush.solid(Color(KodeinColors.light_orange))
                    )
                ),
                contentDescription = "Kodein CuP",
                modifier = Modifier.size(96.dp)
            )

            KodeinAnimatedVisibility(
                visible = step >= 3,
            ) {
                BulletPoints(
                    spacedBy = 2.dp,
                    modifier = Modifier.padding(start = 32.dp)
                ) {
                    item { Text("Multi-step slides") }
                    item { Text("Animations") }
                    item { Text("Code highlighting") }
                    item { Text("Speaker notes") }
                    item { Text("Laser pointer") }
                    item { Text("PDF export") }
                    item { Text("...and more!") }
                }
            }
        }
    }
}

// Row Slow Animated Visibility
@Composable
private fun RowScope.RSAV(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        modifier = modifier,
        enter = fadeIn(tween(1500)) + expandHorizontally(tween(1500)),
        exit = fadeOut(tween(1500)) + shrinkHorizontally(tween(1500)),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

