package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.findRootCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import net.kodein.cup.LocalPresentationState
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.cup.currentSlide
import net.kodein.theme.cup.ui.KodeinLogo
import net.kodein.theme.cup.ui.defaultKodeinAnimationDuration
import org.jetbrains.compose.resources.imageResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m3.TextWithNotoImageEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink
import presentation.generated.resources.Res
import presentation.generated.resources.kc26_lanyard


class LanyardState {
    var xOffset: Float by mutableStateOf(0f)
    var width: Float by mutableStateOf(0f)

    companion object {
        val local: ProvidableCompositionLocal<LanyardState> = compositionLocalOf { error("No lanyard state") }
    }
}

val outro by Slide(
    specs = SlideSpecs(
        size = SLIDE_SIZE_16_9,
    )
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            KodeinLogo("koders", Modifier.height(64.dp)) { Text("Salomon BRYS", fontSize = 1.15.em) }

            Spacer(Modifier.height(32.dp))

            LinksToThisPresentation()

            Spacer(Modifier.height(32.dp))

            Text(
                text = "Thank you!",
                style = MaterialTheme.typography.displayLarge
            )
            TextWithNotoImageEmoji(
                text = "(And don't forget to vote ${Emoji.Wink})",
            )
        }
        Box(
            modifier = Modifier
                .graphicsLayer {
                    compositingStrategy = CompositingStrategy.Offscreen
                }
        ) {
            val lanyardState by rememberUpdatedState(LanyardState.local.current)
            Box(
                modifier = Modifier
                    .width(256.dp)
                    .fillMaxHeight()
                    .onGloballyPositioned {
                        lanyardState.xOffset = it.positionInWindow().x
                        lanyardState.width = it.size.width.toFloat()
                    }
            )
        }
    }
}

@Composable
fun BoxScope.outroLanyard() {
    AnimatedVisibility(
        visible = LocalPresentationState.current.currentSlide == outro,
        enter = slideInVertically(tween(2_500)) { -it },
        exit = fadeOut(tween(defaultKodeinAnimationDuration)),
    ) {
        val density = LocalDensity.current
        val lanyardState = LanyardState.local.current
        var yDelta by remember { mutableStateOf(0f) }
        Image(
            bitmap = imageResource(Res.drawable.kc26_lanyard),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .align(Alignment.TopStart)
                .width(with(density) { lanyardState.width.toDp() })
                .wrapContentHeight(unbounded = true)
                .onGloballyPositioned {
                    val rootHeight = it.findRootCoordinates().size.height
                    yDelta = if (it.size.height > rootHeight) {
                        (it.size.height - rootHeight).toFloat()
                    } else 0f
                }
                .graphicsLayer {
                    translationX = lanyardState.xOffset
                    translationY = -yDelta - 20.dp.toPx()
                }
        )
    }
}