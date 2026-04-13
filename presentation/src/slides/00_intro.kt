package slides

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.qrose.options.*
import io.github.alexzhirkevich.qrose.rememberQrCodePainter
import net.kodein.cup.Slide
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.kStyled
import net.kodein.theme.cup.ui.KodeinLogo
import kotlin.time.Duration.Companion.seconds


@Composable
fun LinksToThisPresentation() {
    Link(
        uri = "https://p.kodein.net/shortcode"
    ) {
        Text(
            text = "https://p.kodein.net/shortcode",
            style = MaterialTheme.typography.labelMedium,
            color = Color(KodeinColors.light_orange)
        )
    }
    Image(
        painter = rememberQrCodePainter(
            "https://p.kodein.net/shortcode",
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
        modifier = Modifier.padding(8.dp)
    )
}

val intro by Slide {

    KodeinLogo("koders", Modifier.height(64.dp)) {}

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

    Text(
        text = kStyled { "${+m}KotlinConf${-m} - 21 May 2026" },
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Light
    )

    Text(
        text = "Salomon BRYS",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        color = Color(KodeinColors.light_orange)
    )

    Spacer(Modifier.height(32.dp))

    LinksToThisPresentation()

}
