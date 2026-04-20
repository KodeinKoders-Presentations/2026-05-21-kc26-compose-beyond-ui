package utils

import java.util.Locale

actual fun format(value: Float): String = String.format(Locale.ROOT, "%.2f", value)
