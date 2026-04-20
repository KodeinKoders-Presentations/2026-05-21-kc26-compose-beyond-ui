import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
import slides.cup
import slides.density
import slides.display
import slides.hello
import slides.intro
import slides.outro


fun presentationApplication() = cupApplication(
    // TODO: Change title
    title = "Compose Beyond UI"
) {
    KodeinPresentation(
        slides = presentationSlides,
    )
}

val presentationSlides = Slides(
    intro,
    hello,
    density,
    display,
    cup,
    kodeinActivities,
    outro
)
