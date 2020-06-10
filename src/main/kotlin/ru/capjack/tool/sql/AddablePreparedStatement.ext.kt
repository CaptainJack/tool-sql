package ru.capjack.tool.sql

inline fun <E : Enum<E>> AddablePreparedStatement.addEnum(x: E?, mapper: (E) -> String) {
	setString(nextIndex(), x?.let(mapper))
}
