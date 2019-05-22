package ru.capjack.tool.sql

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.*
import java.sql.Date
import java.util.*

internal class AddablePreparedStatementImpl(private val source: PreparedStatement) : AddablePreparedStatement, PreparedStatement by source {
	private var index: Int = 0
	
	override fun addNull(sqlType: Int) {
		source.setNull(++index, sqlType)
	}
	
	override fun addBoolean(x: Boolean) {
		source.setBoolean(++index, x)
	}
	
	override fun addByte(x: Byte) {
		source.setByte(++index, x)
	}
	
	override fun addShort(x: Short) {
		source.setShort(++index, x)
	}
	
	override fun addInt(x: Int) {
		source.setInt(++index, x)
	}
	
	override fun addLong(x: Long) {
		source.setLong(++index, x)
	}
	
	override fun addFloat(x: Float) {
		source.setFloat(++index, x)
	}
	
	override fun addDouble(x: Double) {
		source.setDouble(++index, x)
	}
	
	override fun addBigDecimal(x: BigDecimal) {
		source.setBigDecimal(++index, x)
	}
	
	override fun addString(x: String) {
		source.setString(++index, x)
	}
	
	override fun addBytes(x: ByteArray) {
		source.setBytes(++index, x)
	}
	
	override fun addDate(x: Date) {
		source.setDate(++index, x)
	}
	
	override fun addTime(x: Time) {
		source.setTime(++index, x)
	}
	
	override fun addTimestamp(x: Timestamp) {
		source.setTimestamp(++index, x)
	}
	
	override fun addAsciiStream(x: InputStream, length: Int) {
		source.setAsciiStream(++index, x, length)
	}
	
	override fun addBinaryStream(x: InputStream, length: Int) {
		source.setBinaryStream(++index, x, length)
	}
	
	override fun addObject(x: Any, targetSqlType: Int) {
		source.setObject(++index, x, targetSqlType)
	}
	
	override fun addObject(x: Any) {
		source.setObject(++index, x)
	}
	
	override fun addCharacterStream(reader: Reader, length: Int) {
		source.setCharacterStream(++index, reader, length)
	}
	
	override fun addRef(x: Ref) {
		source.setRef(++index, x)
	}
	
	override fun addBlob(x: Blob) {
		source.setBlob(++index, x)
	}
	
	override fun addClob(x: Clob) {
		source.setClob(++index, x)
	}
	
	override fun addArray(x: java.sql.Array) {
		source.setArray(++index, x)
	}
	
	override fun addDate(x: Date, cal: Calendar) {
		source.setDate(++index, x, cal)
	}
	
	override fun addTime(x: Time, cal: Calendar) {
		source.setTime(++index, x, cal)
	}
	
	override fun addTimestamp(x: Timestamp, cal: Calendar) {
		source.setTimestamp(++index, x, cal)
	}
	
	override fun addNull(sqlType: Int, typeName: String) {
		source.setNull(++index, sqlType, typeName)
	}
	
	override fun addURL(x: URL) {
		source.setURL(++index, x)
	}
	
	override fun addRowId(x: RowId) {
		source.setRowId(++index, x)
	}
	
	override fun addNString(value: String) {
		source.setNString(++index, value)
	}
	
	override fun addNCharacterStream(value: Reader, length: Long) {
		source.setNCharacterStream(++index, value, length)
	}
	
	override fun addNClob(value: NClob) {
		source.setNClob(++index, value)
	}
	
	override fun addClob(reader: Reader, length: Long) {
		source.setClob(++index, reader, length)
	}
	
	override fun addBlob(inputStream: InputStream, length: Long) {
		source.setBlob(++index, inputStream, length)
	}
	
	override fun addNClob(reader: Reader, length: Long) {
		source.setNClob(++index, reader, length)
	}
	
	override fun addSQLXML(xmlObject: SQLXML) {
		source.setSQLXML(++index, xmlObject)
	}
	
	override fun addObject(x: Any, targetSqlType: Int, scaleOrLength: Int) {
		source.setObject(++index, x, targetSqlType, scaleOrLength)
	}
	
	override fun addAsciiStream(x: InputStream, length: Long) {
		source.setAsciiStream(++index, x, length)
	}
	
	override fun addBinaryStream(x: InputStream, length: Long) {
		source.setBinaryStream(++index, x, length)
	}
	
	override fun addCharacterStream(reader: Reader, length: Long) {
		source.setCharacterStream(++index, reader, length)
	}
	
	override fun addAsciiStream(x: InputStream) {
		source.setAsciiStream(++index, x)
	}
	
	override fun addBinaryStream(x: InputStream) {
		source.setBinaryStream(++index, x)
	}
	
	override fun addCharacterStream(reader: Reader) {
		source.setCharacterStream(++index, reader)
	}
	
	override fun addNCharacterStream(value: Reader) {
		source.setNCharacterStream(++index, value)
	}
	
	override fun addClob(reader: Reader) {
		source.setClob(++index, reader)
	}
	
	override fun addBlob(inputStream: InputStream) {
		source.setBlob(++index, inputStream)
	}
	
	override fun addNClob(reader: Reader) {
		source.setNClob(++index, reader)
	}
	
	override fun addObject(x: Any, targetSqlType: SQLType, scaleOrLength: Int) {
		source.setObject(++index, x, targetSqlType, scaleOrLength)
	}
	
	override fun addObject(x: Any, targetSqlType: SQLType) {
		source.setObject(++index, x, targetSqlType)
	}
}
