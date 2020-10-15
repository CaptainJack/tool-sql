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


///

inline fun <R> DataSource.execute(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { execute(sql, result) }
}

inline fun DataSource.iterate(@Language("SQL") sql: String, action: ResultSet.() -> Unit) {
	connection { iterate(sql, action) }
}

inline fun <E> DataSource.map(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	return connection { map(sql, transform) }
}

inline fun <K, V> DataSource.associate(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { associate(sql, transform) }
}

inline fun <K, V> DataSource.group(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { group(sql, transform) }
}

inline fun <R> DataSource.get(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { get(sql, result) }
}

inline fun <R> DataSource.getOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, other: () -> R): R {
	return connection { getOrElse(sql, result, other) }
}

inline fun <R> DataSource.getMaybe(@Language("SQL") sql: String, result: ResultSet.() -> R): R? {
	return connection { getMaybe(sql, result) }
}

fun DataSource.exists(@Language("SQL") sql: String): Boolean {
	return connection { exists(sql) }
}


///

fun DataSource.update(@Language("SQL") sql: String): Int {
	return connection { update(sql) }
}

fun DataSource.updateMaybe(@Language("SQL") sql: String): Int {
	return connection { updateMaybe(sql) }
}

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, other: () -> Unit) {
	return connection { updateOrElse(sql, other) }
}

fun DataSource.updateAndGetGeneratedKeyInt(@Language("SQL") sql: String): Int {
	return connection { updateAndGetGeneratedKeyInt(sql) }
}

fun DataSource.updateAndGetGeneratedKeyLong(@Language("SQL") sql: String): Long {
	return connection { updateAndGetGeneratedKeyLong(sql) }
}


fun DataSource.updateAndGetGeneratedKeyIntMaybe(@Language("SQL") sql: String): Int? {
	return connection { updateAndGetGeneratedKeyIntMaybe(sql) }
}

fun DataSource.updateAndGetGeneratedKeyLongMaybe(@Language("SQL") sql: String): Long? {
	return connection { updateAndGetGeneratedKeyLongMaybe(sql) }
}


fun DataSource.updateAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, other: () -> Int): Int {
	return connection { updateAndGetGeneratedKeyIntOrElse(sql, other) }
}

fun DataSource.updateAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, other: () -> Long): Long {
	return connection { updateAndGetGeneratedKeyLongOrElse(sql, other) }
}


// Prepared

inline fun <R> DataSource.execute(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { execute(sql, setup, result) }
}

inline fun DataSource.iterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	connection { iterate(sql, setup, action) }
}

inline fun <E> DataSource.map(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	return connection { map(sql, setup, transform) }
}

inline fun <K, V> DataSource.associate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { associate(sql, setup, transform) }
}

inline fun <K, V> DataSource.group(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { group(sql, setup, transform) }
}

inline fun <R> DataSource.get(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { get(sql, setup, result) }
}

inline fun <R> DataSource.getOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, other: () -> R): R {
	return connection { getOrElse(sql, setup, result, other) }
}

inline fun <R> DataSource.getMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R? {
	return connection { getMaybe(sql, setup, result) }
}

inline fun DataSource.exists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection { exists(sql, setup) }
}


///

inline fun DataSource.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { update(sql, setup) }
}

inline fun DataSource.updateMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { updateMaybe(sql, setup) }
}

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Unit) {
	connection { updateOrElse(sql, setup, other) }
}


inline fun DataSource.updateAndGetGeneratedKeyInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { updateAndGetGeneratedKeyInt(sql, setup) }
}

inline fun DataSource.updateAndGetGeneratedKeyLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return connection { updateAndGetGeneratedKeyLong(sql, setup) }
}


inline fun DataSource.updateAndGetGeneratedKeyIntMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int? {
	return connection { updateAndGetGeneratedKeyIntMaybe(sql, setup) }
}

inline fun DataSource.updateAndGetGeneratedKeyLongMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long? {
	return connection { updateAndGetGeneratedKeyLongMaybe(sql, setup) }
}


inline fun DataSource.updateAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Int): Int {
	return connection { updateAndGetGeneratedKeyIntOrElse(sql, setup, other) }
}

inline fun DataSource.updateAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: () -> Long): Long {
	return connection { updateAndGetGeneratedKeyLongOrElse(sql, setup, other) }
}

