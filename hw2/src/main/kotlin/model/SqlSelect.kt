package model

data class SqlSelect(
    val select: String,
    val from: String,
    val where: String
) {

    override fun toString() = "$select$from$where"
}
