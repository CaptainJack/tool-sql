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

inline fun <E> DataSource.fetchList(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	return connection { fetchList(sql, transform) }
}

inline fun <K, V> DataSource.fetchMap(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { fetchMap(sql, transform) }
}

inline fun <K, V> DataSource.fetchGroups(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { fetchGroups(sql, transform) }
}

inline fun <R> DataSource.fetch(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return connection { fetch(sql, result) }
}

inline fun <R> DataSource.fetchOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, other: Connection.() -> R): R {
	return connection { fetchOrElse(sql, result, other) }
}

inline fun <R> DataSource.fetchMaybe(@Language("SQL") sql: String, result: ResultSet.() -> R): R? {
	return connection { fetchMaybe(sql, result) }
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

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, other: Connection.() -> Unit) {
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


fun DataSource.updateAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, other: Connection.() -> Int): Int {
	return connection { updateAndGetGeneratedKeyIntOrElse(sql, other) }
}

fun DataSource.updateAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, other: Connection.() -> Long): Long {
	return connection { updateAndGetGeneratedKeyLongOrElse(sql, other) }
}


// Prepared

inline fun <R> DataSource.execute(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { execute(sql, setup, result) }
}

inline fun DataSource.iterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	connection { iterate(sql, setup, action) }
}

inline fun <E> DataSource.fetchList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	return connection { fetchList(sql, setup, transform) }
}

inline fun <K, V> DataSource.fetchMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	return connection { fetchMap(sql, setup, transform) }
}

inline fun <K, V> DataSource.fetchGroups(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	return connection { fetchGroups(sql, setup, transform) }
}

inline fun <R> DataSource.fetch(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return connection { fetch(sql, setup, result) }
}

inline fun <R> DataSource.fetchOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, other: Connection.() -> R): R {
	return connection { fetchOrElse(sql, setup, result, other) }
}

inline fun <R> DataSource.fetchMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R? {
	return connection { fetchMaybe(sql, setup, result) }
}

inline fun DataSource.exists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection { exists(sql, setup) }
}


inline fun <E, R> DataSource.fetchListSeparately(
	@Language("SQL") sql: String,
	collection: Collection<E>,
	setup: AddablePreparedStatement.(E) -> Unit,
	transform: ResultSet.(E) -> R
): List<R> {
	return connection { fetchListSeparately(sql, collection, setup, transform) }
}

///

inline fun DataSource.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { update(sql, setup) }
}

inline fun DataSource.updateMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { updateMaybe(sql, setup) }
}

inline fun DataSource.updateOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Unit) {
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


inline fun DataSource.updateAndGetGeneratedKeyIntOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Int): Int {
	return connection { updateAndGetGeneratedKeyIntOrElse(sql, setup, other) }
}

inline fun DataSource.updateAndGetGeneratedKeyLongOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Long): Long {
	return connection { updateAndGetGeneratedKeyLongOrElse(sql, setup, other) }
}

inline fun <E> DataSource.updateBatch(@Language("SQL") sql: String, collection: Collection<E>, batch: Int = collection.size, setup: AddablePreparedStatement.(E) -> Unit) {
	connection { updateBatch(sql, collection, batch, setup) }
}

///


inline fun DataSource.getOrPutGeneratedKeyInt(
	@Language("SQL") get: String, getSetup: AddablePreparedStatement.() -> Unit,
	@Language("SQL") put: String, putSetup: AddablePreparedStatement.() -> Unit,
): Int {
	return connection { getOrPutGeneratedKeyInt(get, getSetup, put, putSetup) }
}

///

fun DataSource.fetchInt(@Language("SQL") sql: String): Int {
	return connection { fetchInt(sql) }
}

inline fun DataSource.fetchIntOrElse(@Language("SQL") sql: String, other: Connection.() -> Int): Int {
	return connection { fetchIntOrElse(sql, other) }
}

fun DataSource.fetchIntMaybe(@Language("SQL") sql: String): Int? {
	return connection { fetchIntMaybe(sql) }
}

inline fun DataSource.fetchInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return connection { fetchInt(sql, setup) }
}

inline fun DataSource.fetchIntOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Int): Int {
	return connection { fetchIntOrElse(sql, setup, other) }
}

inline fun DataSource.fetchIntMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int? {
	return connection { fetchIntMaybe(sql, setup) }
}

///

fun DataSource.fetchLong(@Language("SQL") sql: String): Long {
	return connection { fetchLong(sql) }
}

inline fun DataSource.fetchLongOrElse(@Language("SQL") sql: String, other: Connection.() -> Long): Long {
	return connection { fetchLongOrElse(sql, other) }
}

fun DataSource.fetchLongMaybe(@Language("SQL") sql: String): Long? {
	return connection { fetchLongMaybe(sql) }
}

inline fun DataSource.fetchLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return connection { fetchLong(sql, setup) }
}

inline fun DataSource.fetchLongOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Long): Long {
	return connection { fetchLongOrElse(sql, setup, other) }
}

inline fun DataSource.fetchLongMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long? {
	return connection { fetchLongMaybe(sql, setup) }
}

///


fun DataSource.fetchBoolean(@Language("SQL") sql: String): Boolean {
	return connection { fetchBoolean(sql) }
}

inline fun DataSource.fetchBooleanOrElse(@Language("SQL") sql: String, other: Connection.() -> Boolean): Boolean {
	return connection { fetchBooleanOrElse(sql, other) }
}

fun DataSource.fetchBooleanMaybe(@Language("SQL") sql: String): Boolean? {
	return connection { fetchBooleanMaybe(sql) }
}

inline fun DataSource.fetchBoolean(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return connection { fetchBoolean(sql, setup) }
}

inline fun DataSource.fetchBooleanOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, other: Connection.() -> Boolean): Boolean {
	return connection { fetchBooleanOrElse(sql, setup, other) }
}

inline fun DataSource.fetchBooleanMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean? {
	return connection { fetchBooleanMaybe(sql, setup) }
}