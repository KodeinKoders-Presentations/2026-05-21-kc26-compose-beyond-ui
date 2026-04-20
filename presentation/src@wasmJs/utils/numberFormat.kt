package utils

@OptIn(ExperimentalWasmJsInterop::class)
actual fun format(value: Float): String = js("value.toFixed(2)")
