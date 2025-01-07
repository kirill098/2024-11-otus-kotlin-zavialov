package model

data class SqlSelect(
    val fields: String,
    val table: String,
    val where: String
) {

    override fun toString(): String {
        var sql = "select $fields from $table"
        if (!where.isNullOrBlank()) {
            sql += " where $where"
        }
        return sql
    }
}
