package model.dsl

import model.SqlSelect

@SqlSelectDsl
class SqlSelectBuilder {
    private var select: String = "select *"
    private var from: String = ""
    private var where: String = ""

    fun select(vararg fields: String) {
        this.select = "select ${fields.joinToString()}"
    }

    fun from(table: String) {
        this.from = " from $table"
    }

    fun where(block: WhereContext.() -> Unit) {
        val ctx = WhereContext().apply(block)
        this.where = ctx.build()
    }

    fun build(): String {
        if (from.isNullOrBlank()) {
            throw IllegalArgumentException("Table name not filled")
        }
        return SqlSelect(
            select = select,
            from = from,
            where = where
        ).toString()
    }
}