package ru.capjack.tool.sql

inline fun <E : Enum<E>> AddablePreparedStatement.addEnum(x: E?, mapper: (E) -> String) {
	setString(nextIndex(), x?.let(mapper))
}

inline fun <E> AddablePreparedStatement.addInClauses(list: Collection<E>, adder: AddablePreparedStatement.(E) -> Unit) {
	list.forEach { this.adder(it) }
}

inline fun <E> AddablePreparedStatement.addInClauses(list: Array<E>, adder: AddablePreparedStatement.(E) -> Unit) {
	list.forEach { this.adder(it) }
}