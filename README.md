Colorize Kotlin
===============

Colorize terminal output.

## Usage ##
```kotlin
val msg = "Hello, World!"

// print in red
printColorized(msg, color = AnsiColor.Red)

// Print with blue background
printColorized(msg, color = AnsiColor.Blue, style = ColorStyle.Background)

// Alternative way to colorize
println(
    "Foobar".colorize(color = AnsiColor.Purple, style = ColorStyle.Underlined)
)
```

![](assets/demo.png)

## TODO ##
TODO: samples module, upload lib, license
