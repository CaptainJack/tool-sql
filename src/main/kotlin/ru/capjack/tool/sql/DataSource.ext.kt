package ru.capjack.tool.sql

import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource

inline fun <R> DataSource.transaction(block: Connection.() -> R): R {
	return connection.use { it.transaction(block) }
}

// Query

inline fun <R> DataSource.query(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection.use { it.query(sql, result) }
}

inline fun DataSource.queryIterate(@Language("SQL") sql: String, action: ResultSet.() -> Unit) {
	connection.use { it.queryIterate(sql, action) }
}

inline fun <E> DataSource.queryList(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	return connection.use { it.queryList(sql, transform) }
}

inline fun <K, V> DataSource.queryMap(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection.use { it.queryMap(sql, transform) }
}

inline fun <K, V> DataSource.queryMapGroup(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection.use { it.queryMapGroup(sql, transform) }
}

inline fun <R> DataSource.queryFirst(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection.use { it.queryFirst(sql, result) }
}

inline fun <R> DataSource.queryFirstOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, default: () -> R): R {
	return connection.use { it.queryFirstOrElse(sql, result, default) }
}

fun DataSource.queryFirstExists(@Language("SQL") sql: String): Boolean {
	return connection.use { it.queryFirstExists(sql) }
}


// Update

fun DataSource.update(@Language("SQL") sql: String, check: Boolean = true): Int {
	return connection.use { it.update(sql, check) }
}

inline fun DataSource.update(@Language("SQL") sql: String, fail: Connection.() -> Unit) {
	return connection.use { it.update(sql, fail) }
}

fun DataSource.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String): Int {
	return connection.use { it.updateWithReturnGeneratedKeyInt(sql) }
}

fun DataSource.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String): Long {
	return connection.use { it.updateWithReturnGeneratedKeyLong(sql) }
}


// Prepared query

inline fun <R> DataSource.query(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection.use { it.query(sql, setup, result) }
}

inline fun DataSource.queryIterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	connection.use { it.queryIterate(sql, setup, action) }
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


// Prepared update

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
