package ru.capjack.tool.sql

fun createSqlInClauses(size: Int): String {
	require(size > 0)
	val string = StringBuilder(size * 2 - 1)
	string.append('?')
	repeat(size - 1) { string.append(',').append('?') }
	return string.toString()
}

fun createSqlInClauses(list: Collection<*>) = createSqlInClauses(list.size)
fun createSqlInClauses(list: Array<*>) = createSqlInClauses(list.size)