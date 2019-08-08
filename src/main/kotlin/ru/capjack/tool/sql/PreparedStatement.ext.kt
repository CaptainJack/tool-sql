package ru.capjack.tool.sql

import java.sql.PreparedStatement
import java.sql.Timestamp
import java.time.LocalDateTime

fun PreparedStatement.setLocalDateTime(parameterIndex: Int, x: LocalDateTime?) {
	setTimestamp(parameterIndex, if (x == null) null else Timestamp.valueOf(x))
}