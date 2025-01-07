package model.dsl

@SqlSelectDsl
class ConditionContext(
    private val left: String,
    private val right: Any?,
    private val isNegative: Boolean = false
) {
    private val setSign: (String.() -> String) = { if (isNegative) "!$this" else this }

    fun build(): String {
        return when (right) {
            null -> "$left ${"is".setSign()} null"
            is String -> "$left ${"=".setSign()} '${right}'"
            is Number -> "$left ${"=".setSign()} $right"
            else -> throw IllegalArgumentException("Not supported")
        }
    }
}