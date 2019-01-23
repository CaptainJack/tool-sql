package ru.capjack.ktjvm.sql

import java.sql.ResultSet

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