package presentation.core.extensions

fun emptyString(): String = ""

fun String.minLength(length: Int): Boolean = this.length >= length

fun String.validEmail(): Boolean {
    return "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})".toRegex().matches(this)
}

fun String.alphanumeric(): String {
    return "[^A-Za-z0-9 ]".toRegex().replace(this, emptyString())
}

fun String.alphabetic(): String {
    return "[^A-Za-z ]".toRegex().replace(this, emptyString())
}

fun String.numeric(): String {
    return "[^0-9]".toRegex().replace(this, emptyString())
}