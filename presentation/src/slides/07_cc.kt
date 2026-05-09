package slides

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.compose.Link
import net.kodein.theme.cup.ui.KodeinAnimatedVisibility


val cc by Slide(
    stepCount = 2
) { step ->
    ProvideTextStyle(
        MaterialTheme.typography.displayLarge
    ) {
        context(scope: LazyItemScope)
        fun Modifier.slowAnimateItem() = with(scope) {
            animateItem(
                fadeInSpec = tween(1500),
                fadeOutSpec = tween(1500),
                placementSpec = tween(1500),
            )
        }

        fun LazyListScope.compose() = item("compose") {
            Text("Compose", modifier = Modifier.slowAnimateItem())
        }
        fun LazyListScope.r() = item("r") {
            Text("r", modifier = Modifier.slowAnimateItem())
        }
        fun LazyListScope.your() = item("your") {
            Text(" your", modifier = Modifier.slowAnimateItem())
        }
        fun LazyListScope.space() = item("space") {
            Text(" ", modifier = Modifier.slowAnimateItem())
        }
        fun LazyListScope.card() = item("card") {
            Text("Card", modifier = Modifier.slowAnimateItem())
        }
        fun LazyListScope.s() = item("s") {
            Text("s", modifier = Modifier.slowAnimateItem())
        }
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (step == 0) {
                compose()
                your()
                space()
                card()
                s()
            }
            if (step >= 1) {
                card()
                space()
                compose()
                r()
            }
        }
    }

    KodeinAnimatedVisibility(visible = step >= 1, durationMillis = 1500) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Link(
                text = "https://github.com/SalomonBrys/Card-Composer",
                uri = "https://github.com/SalomonBrys/Card-Composer",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = rememberQrCodePainter(
                    "https://github.com/SalomonBrys/Card-Composer",
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
        }
    }
}
