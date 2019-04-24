@file:JvmName("Colorize")

package com.nrojiani.colorize

/*
 * Utilities for printing colorized and stylized (bold, bright, underlined, etc.)
 * text to the standard output stream.
 */

/** Escape sequence code */
private const val ESC = "\u001b["

/** Resets text color */
private const val RESET = "\u001b[0m"

/**
 * Print a colorized & stylized message to the standard output stream.
 */
fun printColorized(
    message: String,
    color: AnsiColor,
    style: ColorStyle = ColorStyle.Regular
) = println(message.colorize(color, style))

/**
 * Wrap a message in the appropriate escape sequences for the provided [color] and [style]
 */
fun String.colorize(
    color: AnsiColor,
    style: ColorStyle = ColorStyle.Regular
): String {
    val code = colorCode(color, style)
    return "$code$this$RESET"
}

/** Generate the code for a given color & style. */
private fun colorCode(color: AnsiColor, style: ColorStyle): String = when (style) {
    ColorStyle.Regular -> "${ESC}0;3${color.code}m"
    ColorStyle.Bold -> "${ESC}1;3${color.code}m"
    ColorStyle.Bright -> "${ESC}0;9${color.code}m"
    ColorStyle.BoldBright -> "${ESC}1;9${color.code}m"
    ColorStyle.Underlined -> "${ESC}4;3${color.code}m"
    ColorStyle.Background -> "${ESC}4${color.code}m"
    ColorStyle.BrightBackground -> "${ESC}0;10${color.code}m"
}
