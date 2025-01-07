package model.dsl

@SqlSelectDsl
class WhereContext {
    private var conditions: MutableList<String> = mutableListOf()
    private var link: String = " and "

    fun or(block: WhereContext.() -> Unit) {
        val ctx = this.apply(block)
        this.link = " or "
    }

    infix fun String.eq(right: Any) {
        val ctx = ConditionContext(this, right)
        conditions.add(ctx.build())
    }

    infix fun String.nonEq(right: Any?) {
        val ctx = ConditionContext(this, right, true)
        conditions.add(ctx.build())
    }


    fun build(): String {
        return if (conditions.size == 1) {
            conditions[0]
        } else {
            conditions.joinToString(link, "(", ")")
        }
    }
}