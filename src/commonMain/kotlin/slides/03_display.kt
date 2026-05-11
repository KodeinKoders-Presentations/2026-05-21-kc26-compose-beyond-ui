package slides

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.PluginCupAPI
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode
import net.kodein.theme.cup.ui.KodeinFadeAnimatedVisibility
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.NotoAnimatedEmoji
import org.kodein.emoji.compose.m3.TextWithNotoAnimatedEmoji
import org.kodein.emoji.people_body.hand_fingers_open.WavingHand
import org.kodein.emoji.smileys_emotion.face_affection.HeartEyes
import utils.OriginalDensityFrame
import kotlin.math.min


@OptIn(PluginCupAPI::class)
val display by Slide(
    stepCount = 4
) { step ->
    Box(Modifier.fillMaxSize()) {
        OriginalDensityFrame {
            val slideSize = Size(480f, 360f)
            val outsideDensity by rememberUpdatedState(LocalDensity.current)
            var insideDensity by remember { mutableStateOf(outsideDensity) }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .onSizeChanged {
                        val wRatio = it.width / slideSize.width
                        val hRatio = it.height / slideSize.height
                        val ratio = min(wRatio, hRatio).coerceAtLeast(0.01f)
                        insideDensity = Density(ratio)
                    }
            ) {
                CompositionLocalProvider(LocalDensity provides insideDensity) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(480.dp, 360.dp)
                            .border(1.dp, MaterialTheme.colorScheme.onBackground)
                    ) {
                        val innerStep = (step - 2).coerceAtLeast(0)
                        AnimatedContent(
                            targetState = innerStep,
                            contentAlignment = Alignment.Center,
                            transitionSpec = {
                                val direction = if (targetState > initialState) 1 else -1
                                ContentTransform(
                                    targetContentEnter = fadeIn(tween(600)) + slideIn(tween(600), initialOffset = { IntOffset(0, it.height / 8 * direction) }),
                                    initialContentExit = fadeOut(tween(600)) + slideOut(tween(600), targetOffset = { IntOffset(0, -it.height / 8 * direction) }),
                                )
                            },
                            modifier = Modifier
                                .fillMaxSize()
                        ) { s ->
                            Box(contentAlignment = Alignment.Center) {
                                when (s) {
                                    0 -> {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            NotoAnimatedEmoji(Emoji.WavingHand, Modifier.padding(16.dp).size(32.dp))
                                            Text(
                                                buildAnnotatedString {
                                                    withStyle(MaterialTheme.typography.displayLarge.toSpanStyle()) {
                                                        appendLine("Hello, KotlinConf!")
                                                    }
                                                    withStyle(MaterialTheme.typography.titleLarge.toSpanStyle()) {
                                                        append("I'm want to show you 2 tricks!")
                                                    }
                                                },
                                                textAlign = TextAlign.Center,
                                            )
                                        }
                                    }
                                    1 -> {
                                        TextWithNotoAnimatedEmoji(
                                            text = "Amazing! ${Emoji.HeartEyes}",
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.displayLarge,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        KodeinFadeAnimatedVisibility(
            visible = step == 1,
            modifier = Modifier.align(Alignment.Center),
        ) {
            KodeinSourceCode(
                sourceCode = rememberSourceCode(
                    language = "kotlin",
                ) {
                    // language="kotlin"
                    """
                        var step by remember { mutableStateOf(0) }
                        //...
                        AnimatedContent(
                            targetState = step,
                        ) { s ->
                            when (s) {
                                0 -> Text("Hello, KotlinConf!")
                                1 -> Text("Amazing!")
                            }
                        }
                    """
                },
                fontSize = 9.sp,
            )
        }
    }
}

