package ru.capjack.tool.ktjvm.sql

import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource

inline fun <R> DataSource.transaction(block: Connection.() -> R): R {
	return connection.use { it.transaction(block) }
}

inline fun <R> DataSource.query(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection.use { it.query(sql, setup, result) }
}

inline fun <E> DataSource.queryList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	return connection.use { it.queryList(sql, setup, transform) }
}

inline fun <K, V> DataSource.queryMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection.use { it.queryMap(sql, setup, transform) }
}

inline fun <K, V> DataSource.queryMapGroup(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection.use { it.queryMapGroup(sql, setup, transform) }
}

inline fun <R> DataSource.queryFirst(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection.use { it.queryFirst(sql, setup, result) }
}

inline fun <R> DataSource.queryFirstOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, default: () -> R): R {
	return connection.use { it.queryFirstOrElse(sql, setup, result, default) }
}

inline fun DataSource.queryFirstExists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection.use { it.queryFirstExists(sql, setup) }
}

inline fun DataSource.update(@Language("SQL") sql: String, check: Boolean = true, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection.use { it.update(sql, check, setup) }
}

inline fun DataSource.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, fail: Connection.() -> Unit) {
	return connection.use { it.update(sql, setup, fail) }
}

inline fun DataSource.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection.use { it.updateWithReturnGeneratedKeyInt(sql, setup) }
}

inline fun DataSource.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return connection.use { it.updateWithReturnGeneratedKeyLong(sql, setup) }
}
