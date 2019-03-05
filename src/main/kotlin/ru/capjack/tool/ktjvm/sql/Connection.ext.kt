package ru.capjack.tool.ktjvm.sql

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

inline fun <R> Connection.query(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, result: ResultSet.() -> R): R {
	AddablePreparedStatement.wrap(prepareStatement(sql)).use { st ->
		st.setup()
		st.executeQuery().use {
			return it.result()
		}
	}
}

inline fun <E> Connection.queryList(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> E): List<E> {
	query(sql, setup) {
		val list = mutableListOf<E>()
		while (next()) {
			list.add(transform(this))
		}
		return list
	}
}

inline fun <K, V> Connection.queryMap(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, V> {
	query(sql, setup) {
		val map = mutableMapOf<K, V>()
		while (next()) {
			val (key, value) = transform(this)
			map[key] = value
		}
		return map
	}
}


inline fun <K, V> Connection.queryMapGroup(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, transform: ResultSet.() -> Pair<K, V>): Map<K, List<V>> {
	query(sql, setup) {
		val map = mutableMapOf<K, MutableList<V>>()
		while (next()) {
			val (key, value) = transform(this)
			map.getOrPut(key) { mutableListOf() }.add(value)
		}
		return map
	}
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

inline fun Connection.update(@Language("SQL") sql: String, check: Boolean = true, setup: AddablePreparedStatement.() -> Unit): Int {
	AddablePreparedStatement.wrap(prepareStatement(sql)).use {
		it.setup()
		val rows = it.executeUpdate()
		if (check && rows == 0) {
			throw SQLException("Update has not made any changes")
		}
		return rows
	}
}

inline fun Connection.update(@Language("SQL") sql: String, setup: AddablePreparedStatement.() -> Unit, fail: Connection.() -> Unit) {
	if (0 == update(sql, false, setup)) {
		fail()
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
