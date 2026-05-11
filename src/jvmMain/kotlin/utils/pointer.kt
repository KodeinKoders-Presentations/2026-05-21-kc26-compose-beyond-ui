package utils

import androidx.compose.ui.input.pointer.PointerIcon
import java.awt.Cursor

actual val PointerIcon.Companion.ResizeNW get() = PointerIcon(Cursor(Cursor.NW_RESIZE_CURSOR))
actual val PointerIcon.Companion.ResizeNE get() = PointerIcon(Cursor(Cursor.NE_RESIZE_CURSOR))
actual val PointerIcon.Companion.ResizeSE get() = PointerIcon(Cursor(Cursor.SE_RESIZE_CURSOR))
actual val PointerIcon.Companion.ResizeSW get() = PointerIcon(Cursor(Cursor.SW_RESIZE_CURSOR))
actual val PointerIcon.Companion.ResizeN get() = PointerIcon(Cursor(Cursor.N_RESIZE_CURSOR))
actual val PointerIcon.Companion.ResizeW get() = PointerIcon(Cursor(Cursor.W_RESIZE_CURSOR))
