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
import net.kodein.cup.Slide
import net.kodein.theme.compose.Link
import org.jetbrains.compose.resources.imageResource
import presentation.generated.resources.Res
import presentation.generated.resources.cup


val cup by Slide(
    stepCount = 10
) { step ->

    AnimatedVisibility(
        visible = step >= 1,
        enter = fadeIn(tween(1500)) + expandVertically(tween(1500)),
        exit = fadeOut(tween(1500)) + shrinkVertically(tween(1500)),
    ) {
        Image(
            bitmap = imageResource(Res.drawable.cup),
            contentDescription = "CuP logo",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clip(CircleShape)
                .size(128.dp)
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
        )
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

