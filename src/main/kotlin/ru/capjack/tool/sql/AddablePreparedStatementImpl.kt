package ru.capjack.tool.sql

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.*
import java.sql.Date
import java.time.LocalDateTime
import java.util.*

internal class AddablePreparedStatementImpl(private val source: PreparedStatement) : AddablePreparedStatement, PreparedStatement by source {
	private var index: Int = 0
	
	override fun nextIndex() = ++index
	
	override fun addLocalDateTime(x: LocalDateTime?) {
		source.setLocalDateTime(nextIndex(), x)
	}
	
	override fun addEnum(x: Enum<*>?) {
		source.setEnum(nextIndex(), x)
	}
	
	override fun addNull(sqlType: Int) {
		source.setNull(nextIndex(), sqlType)
	}
	
	override fun addBoolean(x: Boolean) {
		source.setBoolean(nextIndex(), x)
	}
	
	override fun addByte(x: Byte) {
		source.setByte(nextIndex(), x)
	}
	
	override fun addShort(x: Short) {
		source.setShort(nextIndex(), x)
	}
	
	override fun addInt(x: Int) {
		source.setInt(nextIndex(), x)
	}
	
	override fun addLong(x: Long) {
		source.setLong(nextIndex(), x)
	}
	
	override fun addFloat(x: Float) {
		source.setFloat(nextIndex(), x)
	}
	
	override fun addDouble(x: Double) {
		source.setDouble(nextIndex(), x)
	}
	
	override fun addBigDecimal(x: BigDecimal?) {
		source.setBigDecimal(nextIndex(), x)
	}
	
	override fun addString(x: String?) {
		source.setString(nextIndex(), x)
	}
	
	override fun addBytes(x: ByteArray?) {
		source.setBytes(nextIndex(), x)
	}
	
	override fun addDate(x: Date?) {
		source.setDate(nextIndex(), x)
	}
	
	override fun addTime(x: Time?) {
		source.setTime(nextIndex(), x)
	}
	
	override fun addTimestamp(x: Timestamp?) {
		source.setTimestamp(nextIndex(), x)
	}
	
	override fun addAsciiStream(x: InputStream?, length: Int) {
		source.setAsciiStream(nextIndex(), x, length)
	}
	
	override fun addBinaryStream(x: InputStream?, length: Int) {
		source.setBinaryStream(nextIndex(), x, length)
	}
	
	override fun addObject(x: Any?, targetSqlType: Int) {
		source.setObject(nextIndex(), x, targetSqlType)
	}
	
	override fun addObject(x: Any?) {
		source.setObject(nextIndex(), x)
	}
	
	override fun addCharacterStream(reader: Reader?, length: Int) {
		source.setCharacterStream(nextIndex(), reader, length)
	}
	
	override fun addRef(x: Ref?) {
		source.setRef(nextIndex(), x)
	}
	
	override fun addBlob(x: Blob?) {
		source.setBlob(nextIndex(), x)
	}
	
	override fun addClob(x: Clob?) {
		source.setClob(nextIndex(), x)
	}
	
	override fun addArray(x: java.sql.Array?) {
		source.setArray(nextIndex(), x)
	}
	
	override fun addDate(x: Date?, cal: Calendar) {
		source.setDate(nextIndex(), x, cal)
	}
	
	override fun addTime(x: Time?, cal: Calendar) {
		source.setTime(nextIndex(), x, cal)
	}
	
	override fun addTimestamp(x: Timestamp?, cal: Calendar) {
		source.setTimestamp(nextIndex(), x, cal)
	}
	
	override fun addNull(sqlType: Int, typeName: String) {
		source.setNull(nextIndex(), sqlType, typeName)
	}
	
	override fun addURL(x: URL?) {
		source.setURL(nextIndex(), x)
	}
	
	override fun addRowId(x: RowId?) {
		source.setRowId(nextIndex(), x)
	}
	
	override fun addNString(value: String?) {
		source.setNString(nextIndex(), value)
	}
	
	override fun addNCharacterStream(value: Reader?, length: Long) {
		source.setNCharacterStream(nextIndex(), value, length)
	}
	
	override fun addNClob(value: NClob?) {
		source.setNClob(nextIndex(), value)
	}
	
	override fun addClob(reader: Reader?, length: Long) {
		source.setClob(nextIndex(), reader, length)
	}
	
	override fun addBlob(inputStream: InputStream?, length: Long) {
		source.setBlob(nextIndex(), inputStream, length)
	}
	
	override fun addNClob(reader: Reader?, length: Long) {
		source.setNClob(nextIndex(), reader, length)
	}
	
	override fun addSQLXML(xmlObject: SQLXML?) {
		source.setSQLXML(nextIndex(), xmlObject)
	}
	
	override fun addObject(x: Any?, targetSqlType: Int, scaleOrLength: Int) {
		source.setObject(nextIndex(), x, targetSqlType, scaleOrLength)
	}
	
	override fun addAsciiStream(x: InputStream?, length: Long) {
		source.setAsciiStream(nextIndex(), x, length)
	}
	
	override fun addBinaryStream(x: InputStream?, length: Long) {
		source.setBinaryStream(nextIndex(), x, length)
	}
	
	override fun addCharacterStream(reader: Reader?, length: Long) {
		source.setCharacterStream(nextIndex(), reader, length)
	}
	
	override fun addAsciiStream(x: InputStream?) {
		source.setAsciiStream(nextIndex(), x)
	}
	
	override fun addBinaryStream(x: InputStream?) {
		source.setBinaryStream(nextIndex(), x)
	}
	
	override fun addCharacterStream(reader: Reader?) {
		source.setCharacterStream(nextIndex(), reader)
	}
	
	override fun addNCharacterStream(value: Reader?) {
		source.setNCharacterStream(nextIndex(), value)
	}
	
	override fun addClob(reader: Reader?) {
		source.setClob(nextIndex(), reader)
	}
	
	override fun addBlob(inputStream: InputStream?) {
		source.setBlob(nextIndex(), inputStream)
	}
	
	override fun addNClob(reader: Reader?) {
		source.setNClob(nextIndex(), reader)
	}
	
	override fun addObject(x: Any?, targetSqlType: SQLType, scaleOrLength: Int) {
		source.setObject(nextIndex(), x, targetSqlType, scaleOrLength)
	}
	
	override fun addObject(x: Any?, targetSqlType: SQLType) {
		source.setObject(nextIndex(), x, targetSqlType)
	}
}
