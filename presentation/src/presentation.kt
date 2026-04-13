import net.kodein.cup.Slides
import net.kodein.cup.cupApplication
import net.kodein.theme.cup.KodeinPresentation
import net.kodein.theme.cup.slides.kodeinActivities
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
    kodeinActivities,
    outro
)
