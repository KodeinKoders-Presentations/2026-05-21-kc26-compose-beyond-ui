package slides

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.NotoAnimatedEmoji
import org.kodein.emoji.compose.m3.TextWithNotoAnimatedEmoji
import org.kodein.emoji.smileys_emotion.face_affection.HappyCry
import org.kodein.emoji.smileys_emotion.face_concerned.Cry
import org.kodein.emoji.smileys_emotion.face_smiling.GrinSweat
import org.kodein.emoji.smileys_emotion.face_smiling.SmileWithBigEyes


val thoughts by Slide(
    stepCount = 4
) { step ->
    Row {
        KodeinAnimatedVisibility(step == 0) {
            Text("I always thought")
        }
        KodeinAnimatedVisibility(step >= 1) {
            Text("The truth is")
        }
    }
    ProvideTextStyle(
        MaterialTheme.typography.displayLarge
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("I'm")
            KodeinAnimatedVisibility(step == 0) { Text(" a") }
            Text(" bad")
            KodeinAnimatedVisibility(step >= 1) { Text(" at thinking like a") }
            Text(" designer")
            Text(".")

            KodeinAnimatedVisibility(step == 0) { NotoAnimatedEmoji(Emoji.Cry, Modifier.padding(8.dp).padding(bottom = 8.dp).size(32.dp)) }
            KodeinAnimatedVisibility(step >= 1) { NotoAnimatedEmoji(Emoji.HappyCry, Modifier.padding(8.dp).padding(bottom = 8.dp).size(32.dp)) }
        }
    }
    KodeinAnimatedVisibility(step >= 2) {
        Spacer(Modifier.height(16.dp))
        TextWithNotoAnimatedEmoji("I am however, good at programming ${Emoji.GrinSweat}")
    }
    KodeinAnimatedVisibility(step >= 3) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("So I program my design", style = MaterialTheme.typography.displayLarge)
            NotoAnimatedEmoji(Emoji.SmileWithBigEyes, Modifier.padding(8.dp).padding(bottom = 8.dp).size(32.dp))
        }
    }
}