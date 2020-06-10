package ru.capjack.tool.sql

import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource

inline fun <R> DataSource.connection(code: Connection.() -> R): R {
	return connection.use { it.code() }
}

inline fun <R> DataSource.transaction(code: Connection.() -> R): R {
	return connection { transaction(code) }
}

// Query

inline fun <R> DataSource.query(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { query(sql, result) }
}

inline fun DataSource.queryIterate(@Language("SQL") sql: String, action: ResultSet.() -> Unit) {
	connection { queryIterate(sql, action) }
}

inline fun <E> DataSource.queryList(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	return connection { queryList(sql, transform) }
}

inline fun <K, V> DataSource.queryMap(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { queryMap(sql, transform) }
}

inline fun <K, V> DataSource.queryMapGroup(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { queryMapGroup(sql, transform) }
}

inline fun <R> DataSource.queryFirst(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { queryFirst(sql, result) }
}

inline fun <R> DataSource.queryFirstOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, other: () -> R): R {
	return connection { queryFirstOrElse(sql, result, other) }
}

fun DataSource.queryFirstExists(@Language("SQL") sql: String): Boolean {
	return connection { queryFirstExists(sql) }
}


// Update

fun DataSource.update(@Language("SQL") sql: String): Int {
	return connection { update(sql) }
}

fun DataSource.updateMaybe(@Language("SQL") sql: String): Int {
	return connection { updateMaybe(sql) }
}

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, other: () -> Unit) {
	return connection { updateOrElse(sql, other) }
}


fun DataSource.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String): Int {
	return connection { updateWithReturnGeneratedKeyInt(sql) }
}

fun DataSource.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String): Long {
	return connection { updateWithReturnGeneratedKeyLong(sql) }
}


fun DataSource.updateWithReturnGeneratedKeyIntMaybe(@Language("SQL") sql: String): Int? {
	return connection { updateWithReturnGeneratedKeyIntMaybe(sql) }
}

fun DataSource.updateWithReturnGeneratedKeyLongMaybe(@Language("SQL") sql: String): Long? {
	return connection { updateWithReturnGeneratedKeyLongMaybe(sql) }
}


fun DataSource.updateWithReturnGeneratedKeyIntOrElse(@Language("SQL") sql: String, other: () -> Int): Int {
	return connection { updateWithReturnGeneratedKeyIntOrElse(sql, other) }
}

fun DataSource.updateWithReturnGeneratedKeyLongOrElse(@Language("SQL") sql: String, other: () -> Long): Long {
	return connection { updateWithReturnGeneratedKeyLongOrElse(sql, other) }
}


// Prepared query

inline fun <R> DataSource.query(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { query(sql, setup, result) }
}

inline fun DataSource.queryIterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	connection { queryIterate(sql, setup, action) }
}

inline fun <E> DataSource.queryList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	return connection { queryList(sql, setup, transform) }
}

inline fun <K, V> DataSource.queryMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { queryMap(sql, setup, transform) }
}

inline fun <K, V> DataSource.queryMapGroup(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { queryMapGroup(sql, setup, transform) }
}

inline fun <R> DataSource.queryFirst(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { queryFirst(sql, setup, result) }
}

inline fun <R> DataSource.queryFirstOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, other: () -> R): R {
	return connection { queryFirstOrElse(sql, setup, result, other) }
}

inline fun DataSource.queryFirstExists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection { queryFirstExists(sql, setup) }
}

inline fun <R> DataSource.queryFirstMaybe(@Language("SQL") sql: String, result: ResultSet.() -> R): R? {
	return connection { queryFirstMaybe(sql, result) }
}

inline fun <R> DataSource.queryFirstMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R? {
	return connection { queryFirstMaybe(sql, setup, result) }
}


// Prepared update

inline fun DataSource.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { update(sql, setup) }
}

inline fun DataSource.updateMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { updateMaybe(sql, setup) }
}

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Unit) {
	connection { updateOrElse(sql, setup, other) }
}


inline fun DataSource.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { updateWithReturnGeneratedKeyInt(sql, setup) }
}

inline fun DataSource.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return connection { updateWithReturnGeneratedKeyLong(sql, setup) }
}


inline fun DataSource.updateWithReturnGeneratedKeyIntMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int? {
	return connection { updateWithReturnGeneratedKeyIntMaybe(sql, setup) }
}

inline fun DataSource.updateWithReturnGeneratedKeyLongMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long? {
	return connection { updateWithReturnGeneratedKeyLongMaybe(sql, setup) }
}


inline fun DataSource.updateWithReturnGeneratedKeyIntOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Int): Int {
	return connection { updateWithReturnGeneratedKeyIntOrElse(sql, setup, other) }
}

inline fun DataSource.updateWithReturnGeneratedKeyLongOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Long): Long {
	return connection { updateWithReturnGeneratedKeyLongOrElse(sql, setup, other) }
}

