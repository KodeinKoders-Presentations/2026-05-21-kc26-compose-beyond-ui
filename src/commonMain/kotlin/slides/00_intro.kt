package slides

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import compose_beyond_ui.generated.resources.Res
import compose_beyond_ui.generated.resources.kc26_background
import compose_beyond_ui.generated.resources.kc26_logo
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
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.Slide
import net.kodein.cup.SlideSpecs
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.ui.KodeinLogo
import org.jetbrains.compose.resources.imageResource


@Composable
fun LinksToThisPresentation() {
    Link(
        uri = "https://p.kodein.net/kc26"
    ) {
        Text(
            text = "https://p.kodein.net/kc26",
            style = MaterialTheme.typography.labelMedium,
            color = Color(KodeinColors.light_orange)
        )
    }
    Image(
        painter = rememberQrCodePainter(
            "https://p.kodein.net/kc26",
            shapes = QrShapes(
                ball = QrBallShape.roundCorners(.25f),
                frame = QrFrameShape.roundCorners(.25f),
                darkPixel = QrPixelShape.circle(),
            ),
            colors = QrColors(
                dark = QrBrush.solid(Color(KodeinColors.light_orange))
            )
        ),
        contentDescription = "This presentation",
        modifier = Modifier.padding(8.dp).size(64.dp)
    )
}

val intro by Slide(
    specs = SlideSpecs(
        size = SLIDE_SIZE_16_9
    )
) {
    Image(
        bitmap = imageResource(Res.drawable.kc26_logo),
        contentDescription = "KotlinConf 2026 Logo",
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .width(128.dp)
            .align(Alignment.Start)
    )

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(32.dp))

            KodeinLogo("koders", Modifier.height(64.dp)) { Text("Salomon BRYS", fontSize = 1.15.em) }

            Spacer(Modifier.height(16.dp))

            val value by rememberInfiniteTransition().animateFloat(
                initialValue = .9f,
                targetValue = 1.1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(3000),
                    repeatMode = RepeatMode.Reverse
                )
            )
            Text(
                text = "Compose beyond UI",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier
                    .scale(value)
            )
        }
        Image(
            bitmap = imageResource(Res.drawable.kc26_background),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(256.dp)
        )
    }
}
