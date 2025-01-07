package model.dsl

import model.SqlSelect

@SqlSelectDsl
class SqlSelectBuilder {
    private var fields: String = "*"
    private var table: String = ""
    private var where: String = ""

    fun select(vararg fields: String) {
        this.fields = fields.joinToString()
    }

    fun from(table: String) {
        this.table = table
    }

    fun where(block: WhereContext.() -> Unit) {
        val ctx = WhereContext().apply(block)
        this.where = ctx.build()
    }

    fun build(): String {
        if (table.isNullOrBlank()) {
            throw IllegalArgumentException("Table name not filled")
        }
        return SqlSelect(
            fields = fields,
            table = table,
            where = where
        ).toString()
    }
}