package utils

import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

@OptIn(ExperimentalWasmJsInterop::class)
actual fun format(value: Float): String = js("value.toFixed(2)")
