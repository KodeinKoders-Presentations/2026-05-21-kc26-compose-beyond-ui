package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.theme.cup.ui.KodeinAnimatedVisibility
import org.jetbrains.compose.resources.imageResource
import compose_beyond_ui.generated.resources.Res
import compose_beyond_ui.generated.resources.kod7_domino_bang
import compose_beyond_ui.generated.resources.kod7_domino_mutation
import compose_beyond_ui.generated.resources.kod7_domino_number
import compose_beyond_ui.generated.resources.kod7_poker_bang
import compose_beyond_ui.generated.resources.kod7_poker_mutation
import compose_beyond_ui.generated.resources.kod7_poker_number


val kod7 by Slide(
    stepCount = 2
) { step ->
    Row(
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        ProvideTextStyle(MaterialTheme.typography.displayLarge) {
            Text("The Kod-7 ")
            KodeinAnimatedVisibility(step == 0) {
                Text("question...")
            }
            KodeinAnimatedVisibility(step >= 1) {
                Text("choice!")
            }
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(Modifier.height(184.dp)) {
            KodeinAnimatedVisibility(step == 0) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_domino_number),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
            KodeinAnimatedVisibility(step >= 1) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_poker_number),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
        }
        Row(Modifier.height(184.dp)) {
            KodeinAnimatedVisibility(step == 0) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_domino_bang),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
            KodeinAnimatedVisibility(step >= 1) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_poker_bang),
                    contentDescription = null,
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
        }
        Column(Modifier.width(184.dp)) {
            KodeinAnimatedVisibility(step == 0) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_domino_mutation),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
            KodeinAnimatedVisibility(step >= 1) {
                Image(
                    bitmap = imageResource(Res.drawable.kod7_poker_mutation),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(6.dp))
                )
            }
        }
    }
}
