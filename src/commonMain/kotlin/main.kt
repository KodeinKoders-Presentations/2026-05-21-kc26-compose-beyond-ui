import androidx.compose.runtime.CompositionLocalProvider
import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
import slides.LanyardState
import slides.cc
import slides.cup
import slides.density
import slides.display
import slides.games
import slides.hello
import slides.intro
import slides.kod7
import slides.noir
import slides.outro
import slides.outroLanyard
import slides.thoughts


fun main() = cupApplication(
    title = "Compose beyond UI"
) {
    KodeinPresentation(
        slides = presentationSlides,
    ) { content ->
        CompositionLocalProvider(
            LanyardState.local provides LanyardState(),
        ) {
            content()
            outroLanyard()
        }
    }
}

val presentationSlides = Slides(
    intro,
    hello,
    density,
    display,
    cup,
    games,
    noir,
    kod7,
    cc,
    thoughts,
    kodeinActivities,
    outro
)
