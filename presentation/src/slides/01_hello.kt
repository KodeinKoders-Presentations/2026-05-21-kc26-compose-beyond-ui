package slides

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.PluginCupAPI
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.theme.cup.KodeinSourceCode
import net.kodein.theme.cup.ui.KodeinFadeAnimatedVisibility
import utils.OriginalDensityFrame


@OptIn(PluginCupAPI::class)
val hello by Slide(
    stepCount = 5
) { step ->
    Box(Modifier.fillMaxSize()) {
        OriginalDensityFrame {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(480.dp, 360.dp)
                    .border(1.dp, MaterialTheme.colorScheme.onBackground)
            ) {
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

        KodeinFadeAnimatedVisibility(
            visible = step in 1..3,
            modifier = Modifier.align(Alignment.Center),
        ) {
            KodeinSourceCode(
                step = step,
                sourceCode = rememberSourceCode(
                    language = "kotlin",
                ) {
                    val S by marker(highlighted(2))
                    // language="kotlin"
                    """
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                $S.size(480.dp, 360.dp)$X
                                .border(1.dp, colorScheme.onBackground)
                        ) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(typography.displayLarge) {
                                        appendLine("Hello, KotlinConf!")
                                    }
                                    withStyle(typography.titleLarge) {
                                        append("I'm want to show you 2 tricks!")
                                    }
                                },
                                textAlign = TextAlign.Center,
                            )
                        }
                    """
                },
                fontSize = 10.sp,
            )
        }
    }
}

