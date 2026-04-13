package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.theme.KodeinColors
import net.kodein.theme.compose.Color
import net.kodein.theme.cup.kStyled
import net.kodein.theme.cup.ui.KodeinLogo


val outro by Slide {

    Text(
        text = "Thank you!",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.displayLarge
    )

    Text(
        text = kStyled { "${+m}KotlinConf${-m} - 21 May 2026" },
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Light
    )

    Spacer(Modifier.height(16.dp))

    Text(
        text = "Salomon BRYS",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        color = Color(KodeinColors.light_orange)
    )

    KodeinLogo("koders", Modifier.height(64.dp)) {}

    Spacer(Modifier.height(32.dp))

    LinksToThisPresentation()
}
