package model.dsl

@SqlSelectDsl
class ConditionContext(
    private val left: String,
    private val right: Any?,
    private val inversion: Boolean = false
) {

    fun build(): String {
        return when (right) {
            null -> "$left ${setSign("is")} null"
            is String -> "$left ${setSign("=")} '$right'"
            is Number -> "$left ${setSign("=")} $right"
            else -> throw IllegalArgumentException("Not supported")
        }
    }

    private fun setSign(symbol: String) = if (inversion) "!$symbol" else symbol
}