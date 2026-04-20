@file:OptIn(ExperimentalComposeUiApi::class)

package utils

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.fromKeyword

actual val PointerIcon.Companion.ResizeNW: PointerIcon get() = PointerIcon.fromKeyword("nw-resize")
actual val PointerIcon.Companion.ResizeNE: PointerIcon get() = PointerIcon.fromKeyword("ne-resize")
actual val PointerIcon.Companion.ResizeSE: PointerIcon get() = PointerIcon.fromKeyword("se-resize")
actual val PointerIcon.Companion.ResizeSW: PointerIcon get() = PointerIcon.fromKeyword("sw-resize")
actual val PointerIcon.Companion.ResizeN: PointerIcon get() = PointerIcon.fromKeyword("n-resize")
actual val PointerIcon.Companion.ResizeW: PointerIcon get() = PointerIcon.fromKeyword("w-resize")
