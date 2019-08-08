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
	
	private fun ix() = ++index
	
	override fun addLocalDateTime(x: LocalDateTime?) {
		source.setLocalDateTime(ix(), x)
	}
	
	override fun addNull(sqlType: Int) {
		source.setNull(ix(), sqlType)
	}
	
	override fun addBoolean(x: Boolean) {
		source.setBoolean(ix(), x)
	}
	
	override fun addByte(x: Byte) {
		source.setByte(ix(), x)
	}
	
	override fun addShort(x: Short) {
		source.setShort(ix(), x)
	}
	
	override fun addInt(x: Int) {
		source.setInt(ix(), x)
	}
	
	override fun addLong(x: Long) {
		source.setLong(ix(), x)
	}
	
	override fun addFloat(x: Float) {
		source.setFloat(ix(), x)
	}
	
	override fun addDouble(x: Double) {
		source.setDouble(ix(), x)
	}
	
	override fun addBigDecimal(x: BigDecimal?) {
		source.setBigDecimal(ix(), x)
	}
	
	override fun addString(x: String?) {
		source.setString(ix(), x)
	}
	
	override fun addBytes(x: ByteArray?) {
		source.setBytes(ix(), x)
	}
	
	override fun addDate(x: Date?) {
		source.setDate(ix(), x)
	}
	
	override fun addTime(x: Time?) {
		source.setTime(ix(), x)
	}
	
	override fun addTimestamp(x: Timestamp?) {
		source.setTimestamp(ix(), x)
	}
	
	override fun addAsciiStream(x: InputStream?, length: Int) {
		source.setAsciiStream(ix(), x, length)
	}
	
	override fun addBinaryStream(x: InputStream?, length: Int) {
		source.setBinaryStream(ix(), x, length)
	}
	
	override fun addObject(x: Any?, targetSqlType: Int) {
		source.setObject(ix(), x, targetSqlType)
	}
	
	override fun addObject(x: Any?) {
		source.setObject(ix(), x)
	}
	
	override fun addCharacterStream(reader: Reader?, length: Int) {
		source.setCharacterStream(ix(), reader, length)
	}
	
	override fun addRef(x: Ref?) {
		source.setRef(ix(), x)
	}
	
	override fun addBlob(x: Blob?) {
		source.setBlob(ix(), x)
	}
	
	override fun addClob(x: Clob?) {
		source.setClob(ix(), x)
	}
	
	override fun addArray(x: java.sql.Array?) {
		source.setArray(ix(), x)
	}
	
	override fun addDate(x: Date?, cal: Calendar) {
		source.setDate(ix(), x, cal)
	}
	
	override fun addTime(x: Time?, cal: Calendar) {
		source.setTime(ix(), x, cal)
	}
	
	override fun addTimestamp(x: Timestamp?, cal: Calendar) {
		source.setTimestamp(ix(), x, cal)
	}
	
	override fun addNull(sqlType: Int, typeName: String) {
		source.setNull(ix(), sqlType, typeName)
	}
	
	override fun addURL(x: URL?) {
		source.setURL(ix(), x)
	}
	
	override fun addRowId(x: RowId?) {
		source.setRowId(ix(), x)
	}
	
	override fun addNString(value: String?) {
		source.setNString(ix(), value)
	}
	
	override fun addNCharacterStream(value: Reader?, length: Long) {
		source.setNCharacterStream(ix(), value, length)
	}
	
	override fun addNClob(value: NClob?) {
		source.setNClob(ix(), value)
	}
	
	override fun addClob(reader: Reader?, length: Long) {
		source.setClob(ix(), reader, length)
	}
	
	override fun addBlob(inputStream: InputStream?, length: Long) {
		source.setBlob(ix(), inputStream, length)
	}
	
	override fun addNClob(reader: Reader?, length: Long) {
		source.setNClob(ix(), reader, length)
	}
	
	override fun addSQLXML(xmlObject: SQLXML?) {
		source.setSQLXML(ix(), xmlObject)
	}
	
	override fun addObject(x: Any?, targetSqlType: Int, scaleOrLength: Int) {
		source.setObject(ix(), x, targetSqlType, scaleOrLength)
	}
	
	override fun addAsciiStream(x: InputStream?, length: Long) {
		source.setAsciiStream(ix(), x, length)
	}
	
	override fun addBinaryStream(x: InputStream?, length: Long) {
		source.setBinaryStream(ix(), x, length)
	}
	
	override fun addCharacterStream(reader: Reader?, length: Long) {
		source.setCharacterStream(ix(), reader, length)
	}
	
	override fun addAsciiStream(x: InputStream?) {
		source.setAsciiStream(ix(), x)
	}
	
	override fun addBinaryStream(x: InputStream?) {
		source.setBinaryStream(ix(), x)
	}
	
	override fun addCharacterStream(reader: Reader?) {
		source.setCharacterStream(ix(), reader)
	}
	
	override fun addNCharacterStream(value: Reader?) {
		source.setNCharacterStream(ix(), value)
	}
	
	override fun addClob(reader: Reader?) {
		source.setClob(ix(), reader)
	}
	
	override fun addBlob(inputStream: InputStream?) {
		source.setBlob(ix(), inputStream)
	}
	
	override fun addNClob(reader: Reader?) {
		source.setNClob(ix(), reader)
	}
	
	override fun addObject(x: Any?, targetSqlType: SQLType, scaleOrLength: Int) {
		source.setObject(ix(), x, targetSqlType, scaleOrLength)
	}
	
	override fun addObject(x: Any?, targetSqlType: SQLType) {
		source.setObject(ix(), x, targetSqlType)
	}
}
