package ru.capjack.tool.sql

import org.intellij.lang.annotations.Language
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

inline fun <R> Connection.transaction(block: Connection.() -> R): R {
	val a = autoCommit
	autoCommit = false
	try {
		val r = block()
		commit()
		return r
	}
	catch (e: Throwable) {
		rollback()
		throw e
	}
	finally {
		autoCommit = a
	}
}


// Query

inline fun <R> Connection.query(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	createStatement().use {
		it.executeQuery(sql).use { rs ->
			return rs.result()
		}
	}
}

inline fun Connection.queryIterate(@Language("SQL") sql: String, action: ResultSet.() -> Unit) {
	query(sql) {
		while (next()) {
			action()
		}
	}
}

inline fun <E> Connection.queryList(@Language("SQL") sql: String, transform: ResultSet.() -> E): List<E> {
	val list = mutableListOf<E>()
	queryIterate(sql) {
		list.add(transform())
	}
	return list
}

inline fun <K, V> Connection.queryMap(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	val map = mutableMapOf<K, V>()
	queryIterate(sql) {
		val (key, value) = transform()
		map[key] = value
		
	}
	return map
}

inline fun <K, V> Connection.queryMapGroup(@Language("SQL") sql: String, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	val map = mutableMapOf<K, MutableList<V>>()
	queryIterate(sql) {
		val (key, value) = transform()
		map.getOrPut(key) { mutableListOf() }.add(value)
	}
	return map
}

inline fun <R> Connection.queryFirstOrElse(@Language("SQL") sql: String, result: ResultSet.() -> R, default: () -> R): R {
	query(sql) {
		return if (next()) result() else default()
	}
}

inline fun <R> Connection.queryFirst(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	return queryFirstOrElse(sql, result) {
		throw SQLException("Query has empty result")
	}
}

fun Connection.queryFirstExists(@Language("SQL") sql: String): Boolean {
	return queryFirstOrElse(sql, { true }, { false })
}


// Update

fun Connection.update(@Language("SQL") sql: String): Int {
	val rows = updateMaybe(sql)
	if (rows == 0) {
		throw SQLException("Update has not made any changes")
	}
	return rows
}

fun Connection.updateMaybe(@Language("SQL") sql: String): Int {
	createStatement().use {
		return it.executeUpdate(sql)
	}
}

inline fun Connection.updateOrElse(@Language("SQL") sql: String, alternative: Connection.() -> Unit) {
	if (0 == updateMaybe(sql)) {
		alternative()
	}
}

fun Connection.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String): Long {
	return updateWithReturnGeneratedKeys(sql) { getLong(1) }
}

fun Connection.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String): Int {
	return updateWithReturnGeneratedKeys(sql) { getInt(1) }
}

inline fun <R> Connection.updateWithReturnGeneratedKeys(@Language("SQL") sql: String, result: ResultSet.() -> R): R {
	createStatement().use { st ->
		
		if (st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 0) {
			throw SQLException("Update has not made any changes")
		}
		
		st.generatedKeys.use {
			if (it.next()) {
				return it.result()
			}
			throw SQLException("Update has empty generate keys")
		}
	}
}


// Prepared query

inline fun <R> Connection.query(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	AddablePreparedStatement.wrap(prepareStatement(sql)).use { st ->
		st.setup()
		st.executeQuery().use {
			return it.result()
		}
	}
}

inline fun Connection.queryIterate(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, action: ResultSet.() -> Unit) {
	query(sql, setup) {
		while (next()) {
			action()
		}
	}
}

inline fun <E> Connection.queryList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	val list = mutableListOf<E>()
	queryIterate(sql, setup) {
		list.add(transform())
	}
	return list
}

inline fun <K, V> Connection.queryMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	val map = mutableMapOf<K, V>()
	queryIterate(sql, setup) {
		val (key, value) = transform()
		map[key] = value
		
	}
	return map
}

inline fun <K, V> Connection.queryMapGroup(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	val map = mutableMapOf<K, MutableList<V>>()
	queryIterate(sql, setup) {
		val (key, value) = transform()
		map.getOrPut(key) { mutableListOf() }.add(value)
	}
	return map
}

inline fun <R> Connection.queryFirstOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R, default: () -> R): R {
	query(sql, setup) {
		return if (next()) result() else default()
	}
}

inline fun <R> Connection.queryFirst(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	return queryFirstOrElse(sql, setup, result) {
		throw SQLException("Query has empty result")
	}
}

inline fun Connection.queryFirstExists(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Boolean {
	return queryFirstOrElse(sql, setup, { true }, { false })
}


// Update prepared

inline fun Connection.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	val rows = updateMaybe(sql, setup)
	if (rows == 0) {
		throw SQLException("Update has not made any changes")
	}
	return rows
}

inline fun Connection.updateMaybe(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	AddablePreparedStatement.wrap(prepareStatement(sql)).use {
		it.setup()
		return it.executeUpdate()
	}
}

inline fun Connection.updateOrElse(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, alternative: Connection.() -> Unit) {
	if (0 == updateMaybe(sql, setup)) {
		alternative()
	}
}

inline fun Connection.updateWithReturnGeneratedKeyLong(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Long {
	return updateWithReturnGeneratedKeys(sql, setup) { getLong(1) }
}

inline fun Connection.updateWithReturnGeneratedKeyInt(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit): Int {
	return updateWithReturnGeneratedKeys(sql, setup) { getInt(1) }
}

inline fun <R> Connection.updateWithReturnGeneratedKeys(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	AddablePreparedStatement.wrap(prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)).use { st ->
		st.setup()
		
		if (st.executeUpdate() == 0) {
			throw SQLException("Update has not made any changes")
		}
		
		st.generatedKeys.use {
			if (it.next()) {
				return it.result()
			}
			throw SQLException("Update has empty generate keys")
		}
	}
}
