package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.theme.cup.ui.KodeinAnimatedVisibility
import org.jetbrains.compose.resources.imageResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.NotoAnimatedEmoji
import org.kodein.emoji.smileys_emotion.heart.BeatingHeart
import compose_beyond_ui.generated.resources.Res
import compose_beyond_ui.generated.resources.collection
import compose_beyond_ui.generated.resources.kod7
import compose_beyond_ui.generated.resources.noir
import compose_beyond_ui.generated.resources.rebel_princess


val games by Slide(
    stepCount = 3
) { step ->
    ProvideTextStyle(MaterialTheme.typography.displayLarge) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            KodeinAnimatedVisibility(step >= 1) { NotoAnimatedEmoji(Emoji.BeatingHeart, Modifier.padding(8.dp).padding(bottom = 8.dp).size(32.dp)) }
            KodeinAnimatedVisibility(step >= 1) { Text("I love") }
            KodeinAnimatedVisibility(step < 1) { Text("Do you like") }
            KodeinAnimatedVisibility(step >= 2) { Text(" making") }
            Text(" games")
            KodeinAnimatedVisibility(step >= 1) { Text("!") }
            KodeinAnimatedVisibility(step < 1) { Text("?") }
            KodeinAnimatedVisibility(step >= 1) { NotoAnimatedEmoji(Emoji.BeatingHeart, Modifier.padding(8.dp).padding(bottom = 8.dp).size(32.dp)) }
        }
    }
    KodeinAnimatedVisibility(
        visible = step == 1,
    ) {
        Image(
            bitmap = imageResource(Res.drawable.collection),
            contentDescription = null,
        )
    }
    KodeinAnimatedVisibility(
        visible = step >= 2,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f),
            ) {
                Image(
                    bitmap = imageResource(Res.drawable.rebel_princess),
                    contentDescription = null,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                Image(
                    bitmap = imageResource(Res.drawable.noir),
                    contentDescription = null,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
            }
            Image(
                bitmap = imageResource(Res.drawable.kod7),
                contentDescription = null,
                modifier = Modifier.weight(1f).fillMaxWidth()
            )
        }
    }
}
