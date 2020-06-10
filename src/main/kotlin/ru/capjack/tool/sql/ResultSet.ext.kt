package ru.capjack.tool.sql

import java.sql.ResultSet
import java.time.LocalDateTime

inline fun ResultSet.forNext(block: (ResultSet) -> Unit): Boolean {
	return if (next()) {
		block(this)
		true
	}
	else false
}

inline fun ResultSet.forEach(block: (ResultSet) -> Unit) {
	while (next()) {
		block(this)
	}
}


fun ResultSet.getLocalDateTime(columnIndex: Int): LocalDateTime? {
	return getTimestamp(columnIndex)?.toLocalDateTime()
}

fun ResultSet.getLocalDateTime(columnLabel: String): LocalDateTime? {
	return getTimestamp(columnLabel)?.toLocalDateTime()
}


inline fun <reified E : Enum<E>> ResultSet.getEnum(columnIndex: Int): E? {
	return getEnum<E>(columnIndex, ::enumValueOf)
}

inline fun <reified E : Enum<E>> ResultSet.getEnum(columnLabel: String): E? {
	return getEnum<E>(columnLabel, ::enumValueOf)
}

inline fun <E : Enum<E>> ResultSet.getEnum(columnIndex: Int, mapper: (String) -> E): E? {
	return getString(columnIndex)?.let(mapper)
}

inline fun <E : Enum<E>> ResultSet.getEnum(columnLabel: String, mapper: (String) -> E): E? {
	return getString(columnLabel)?.let(mapper)
}
