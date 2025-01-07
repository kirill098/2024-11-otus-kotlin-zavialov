package model.dsl

@SqlSelectDsl
class WhereContext {
    private val conditions: MutableList<String> = mutableListOf()
    private var union: String = " and "

    fun or(block: WhereContext.() -> Unit) {
        apply(block)
        union = " or "
    }

    infix fun String.eq(right: Any) {
        val ctx = ConditionContext(this, right)
        conditions.add(ctx.build())
    }

    infix fun String.nonEq(right: Any?) {
        val ctx = ConditionContext(this, right, true)
        conditions.add(ctx.build())
    }

    fun build() =
        when (conditions.size) {
            0 -> ""
            1 -> " where ${conditions[0]}"
            else -> " where ${conditions.joinToString(union, "(", ")")}"
        }
}