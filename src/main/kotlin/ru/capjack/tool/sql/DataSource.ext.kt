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


// Fetch

inline fun <R> DataSource.fetch(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { fetch(sql, result) }
}

inline fun DataSource.fetchIterate(@Language("SQL") sql: String, action: ResultSet.() -> Unit) {
	connection { fetchIterate(sql, action) }
}

inline fun <E> DataSource.fetchList(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	return connection { fetchList(sql, transform) }
}

inline fun <K, V> DataSource.fetchMap(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { fetchMap(sql, transform) }
}

inline fun <K, V> DataSource.fetchMapGroup(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { fetchMapGroup(sql, transform) }
}

inline fun <R> DataSource.fetchFirst(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { fetchFirst(sql, result) }
}

inline fun <R> DataSource.fetchFirstOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, other: () -> R): R {
	return connection { fetchFirstOrElse(sql, result, other) }
}

fun DataSource.fetchExists(@Language("SQL") sql: String): Boolean {
	return connection { fetchExists(sql) }
}


// Put

fun DataSource.put(@Language("SQL") sql: String): Int {
	return connection { put(sql) }
}

fun DataSource.putMaybe(@Language("SQL") sql: String): Int {
	return connection { putMaybe(sql) }
}

inline fun DataSource.putOrElse(@Language("SQL") sql: String, other: () -> Unit) {
	return connection { putOrElse(sql, other) }
}


fun DataSource.putAndGetGeneratedKeyInt(@Language("SQL") sql: String): Int {
	return connection { putAndGetGeneratedKeyInt(sql) }
}

fun DataSource.putAndGetGeneratedKeyLong(@Language("SQL") sql: String): Long {
	return connection { putAndGetGeneratedKeyLong(sql) }
}


fun DataSource.putAndGetGeneratedKeyIntMaybe(@Language("SQL") sql: String): Int? {
	return connection { putAndGetGeneratedKeyIntMaybe(sql) }
}

fun DataSource.putAndGetGeneratedKeyLongMaybe(@Language("SQL") sql: String): Long? {
	return connection { putAndGetGeneratedKeyLongMaybe(sql) }
}


fun DataSource.putAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, other: () -> Int): Int {
	return connection { putAndGetGeneratedKeyIntOrElse(sql, other) }
}

fun DataSource.putAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, other: () -> Long): Long {
	return connection { putAndGetGeneratedKeyLongOrElse(sql, other) }
}


// Prepared fetch

inline fun <R> DataSource.fetch(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { fetch(sql, setup, result) }
}

inline fun DataSource.fetchIterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	connection { fetchIterate(sql, setup, action) }
}

inline fun <E> DataSource.fetchList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	return connection { fetchList(sql, setup, transform) }
}

inline fun <K, V> DataSource.fetchMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { fetchMap(sql, setup, transform) }
}

inline fun <K, V> DataSource.fetchMapGroup(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { fetchMapGroup(sql, setup, transform) }
}

inline fun <R> DataSource.fetchFirst(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { fetchFirst(sql, setup, result) }
}

inline fun <R> DataSource.fetchFirstOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, other: () -> R): R {
	return connection { fetchFirstOrElse(sql, setup, result, other) }
}

inline fun DataSource.fetchExists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection { fetchExists(sql, setup) }
}

inline fun <R> DataSource.fetchFirstMaybe(@Language("SQL") sql: String, result: ResultSet.() -> R): R? {
	return connection { fetchFirstMaybe(sql, result) }
}

inline fun <R> DataSource.fetchFirstMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R? {
	return connection { fetchFirstMaybe(sql, setup, result) }
}


// Prepared put

inline fun DataSource.put(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { put(sql, setup) }
}

inline fun DataSource.putMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { putMaybe(sql, setup) }
}

inline fun DataSource.putOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Unit) {
	connection { putOrElse(sql, setup, other) }
}


inline fun DataSource.putAndGetGeneratedKeyInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { putAndGetGeneratedKeyInt(sql, setup) }
}

inline fun DataSource.putAndGetGeneratedKeyLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return connection { putAndGetGeneratedKeyLong(sql, setup) }
}


inline fun DataSource.putAndGetGeneratedKeyIntMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int? {
	return connection { putAndGetGeneratedKeyIntMaybe(sql, setup) }
}

inline fun DataSource.putAndGetGeneratedKeyLongMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long? {
	return connection { putAndGetGeneratedKeyLongMaybe(sql, setup) }
}


inline fun DataSource.putAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Int): Int {
	return connection { putAndGetGeneratedKeyIntOrElse(sql, setup, other) }
}

inline fun DataSource.putAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Long): Long {
	return connection { putAndGetGeneratedKeyLongOrElse(sql, setup, other) }
}

