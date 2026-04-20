package slides

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.sp
import net.kodein.cup.PluginCupAPI
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode
import net.kodein.theme.cup.ui.KodeinFadeAnimatedVisibility
import utils.OriginalDensityFrame
import utils.format
import kotlin.math.min


@OptIn(PluginCupAPI::class)
val density by Slide(
    stepCount = 5
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
                    Text(
                        text = format(insideDensity.density),
                        style = MaterialTheme.typography.displayLarge,
                    )
                }
            }
        }

        KodeinFadeAnimatedVisibility(
            visible = step in 1..4,
            modifier = Modifier.align(Alignment.Center),
        ) {
            KodeinSourceCode(
                step = step,
                sourceCode = rememberSourceCode(
                    language = "kotlin",
                ) {
                    val S1 by marker(highlighted(2))
                    val S2 by marker(highlighted(3))
                    // language="kotlin"
                    """
                        val slideSize = Size(480f, 360f)
                        val outsideDensity by rememberUpdatedState(LocalDensity.current)
                        var insideDensity by remember { mutableStateOf(outsideDensity) }
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .onSizeChanged {
                        $S1            val wRatio = it.width / slideSize.width
                                    val hRatio = it.height / slideSize.height
                                    val ratio = min(wRatio, hRatio)
                                    insideDensity = Density(ratio)
                        $X        }
                        ) {
                        $S2    CompositionLocalProvider(
                                LocalDensity provides insideDensity
                            ) {
                        $X        Text(
                                    text = format(insideDensity.density),
                                    style = MaterialTheme.typography.displayLarge,
                                )
                            }
                        }
                    """
                },
                fontSize = 10.sp,
            )
        }
    }
}

